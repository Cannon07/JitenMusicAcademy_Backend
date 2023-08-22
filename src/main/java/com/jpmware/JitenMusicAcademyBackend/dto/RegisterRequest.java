package com.jpmware.JitenMusicAcademyBackend.dto;

public class RegisterRequest {

    // Fields

    private String first_name;
    private String last_name;
    private String email;
    private String password;

    // Constructors

    public RegisterRequest () {

    }

    public RegisterRequest(String first_name, String last_name, String email, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

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
        return "RegisterRequest [first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
                + ", password=" + password + "]";
    }

}
