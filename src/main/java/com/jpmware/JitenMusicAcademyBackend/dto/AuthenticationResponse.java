package com.jpmware.JitenMusicAcademyBackend.dto;

import com.jpmware.JitenMusicAcademyBackend.entity.User;

public class AuthenticationResponse {

    private User user;
    private String token;

    // Constructor

    public AuthenticationResponse() {

    }

    public AuthenticationResponse(User user, String token) {
        this.user = user;
        this.token = token;
    }

    // Getters and Setters
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // toString() method

    @Override
    public String toString() {
        return "AuthenticationResponse [user=" + user + ", token=" + token + "]";
    }
    
}
