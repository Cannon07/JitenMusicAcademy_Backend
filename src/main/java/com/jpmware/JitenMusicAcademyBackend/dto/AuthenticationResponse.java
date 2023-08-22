package com.jpmware.JitenMusicAcademyBackend.dto;

public class AuthenticationResponse {

    private String token;

    // Constructor

    public AuthenticationResponse() {

    }

    public AuthenticationResponse(String token) {
        this.token = token;
    }

    // Getters and Setters

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // toString() method

    @Override
    public String toString() {
        return "AuthenticationResponse [token=" + token + "]";
    }
    
}
