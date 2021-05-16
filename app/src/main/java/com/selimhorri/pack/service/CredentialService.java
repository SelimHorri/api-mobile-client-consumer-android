package com.selimhorri.pack.service;

import android.content.Context;
import android.util.JsonReader;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.selimhorri.pack.model.Credential;
import com.selimhorri.pack.model.CredentialList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class CredentialService {

    private static String url = "https://project-tracking-system-heroku.herokuapp.com/app/api";
    private Context context;
    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectRequest;

    public CredentialService(final Context context) {
        url += "/userCredentials";
        this.context = context;
        this.requestQueue = Volley.newRequestQueue(context);
    }

    public CredentialList findAll() {

        final CredentialList credentialList = new CredentialList();
        final List<Credential> list = new ArrayList<>();

        this.jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                (response) -> {
                    try {
                        JSONArray jsonUserCredentials = response.getJSONArray("userCredentials");
                        final Credential credential = new Credential();
                        for (int i = 0; i < jsonUserCredentials.length(); i++) {
                            credential.setUserId(jsonUserCredentials.getJSONObject(i).getInt("userId"));
                            credential.setUsername(jsonUserCredentials.getJSONObject(i).getString("username"));
                            credential.setPassword(jsonUserCredentials.getJSONObject(i).getString("password"));
                            credential.setEnabled(jsonUserCredentials.getJSONObject(i).getString("enabled"));
                            credential.setRole(jsonUserCredentials.getJSONObject(i).getString("role"));

                            list.add(credential);
                        }
                        credentialList.setCredentials(Arrays.asList(credential));
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                (error) -> Toast.makeText(this.context, "#### ERROR ####", Toast.LENGTH_LONG).show()
        );

        return credentialList;
    }

    public Credential findById(final Integer userId) {
        return null;
    }



}
