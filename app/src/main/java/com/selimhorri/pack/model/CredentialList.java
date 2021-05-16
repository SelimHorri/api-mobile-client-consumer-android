package com.selimhorri.pack.model;

import java.util.List;

public final class CredentialList {

    private List<Credential> credentials;

    public CredentialList() {

    }

    public CredentialList(List<Credential> credentials) {
        this.credentials = credentials;
    }

    public List<Credential> getCredentials() {
        return credentials;
    }

    public void setCredentials(List<Credential> credentials) {
        this.credentials = credentials;
    }



}
