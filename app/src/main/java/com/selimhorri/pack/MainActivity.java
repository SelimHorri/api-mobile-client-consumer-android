package com.selimhorri.pack;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.selimhorri.pack.model.Credential;
import com.selimhorri.pack.model.CredentialList;
import com.selimhorri.pack.service.CredentialService;

import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CredentialService credentialService;

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.credentialService = new CredentialService(MainActivity.this);
        this.textView = super.findViewById(R.id.textViewDisplayer);
        this.button = super.findViewById(R.id.btnApiCall);

        final String url = "https://project-tracking-system-heroku.herokuapp.com/app/api/userCredentials";
        this.button.setOnClickListener(v -> {

            /*
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                (response) -> this.textView.setText(response.toString()),
                (error) -> this.textView.setText("did not workkkk")
            );

            requestQueue.add(jsonObjectRequest);
            */

            final CredentialList credentialList = this.credentialService.findAll();
            final String username = credentialList.getCredentials().get(0).getUsername();
            this.textView.setText(username);

        });

    }



}