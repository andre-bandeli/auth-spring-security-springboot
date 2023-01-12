package com.autentication.autentication.model.auth;

public class AuthenticantionResponse {

    private String token;

    public AuthenticantionResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
