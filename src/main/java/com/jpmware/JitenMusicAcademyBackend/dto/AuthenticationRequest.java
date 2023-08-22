package com.jpmware.JitenMusicAcademyBackend.dto;

public class AuthenticationRequest {
    
    // Fields

    String email;
    String password;

    // Constructors

    public AuthenticationRequest () {

    }

    public AuthenticationRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters and Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString() method

    @Override
    public String toString() {
        return "AuthenticationRequest [email=" + email + ", password=" + password + "]";
    }
        
}
