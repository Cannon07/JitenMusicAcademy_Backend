package com.jpmware.JitenMusicAcademyBackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {
    
    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private int phone;

    @Column(name = "experience")
    private int experience;

    @Column(name = "photo")
    private String photo;

    // Constructors

    public Instructor() {

    }

    public Instructor(String name, String email, int phone, int experience, String photo) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.experience = experience;
        this.photo = photo;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    // toString() method

    @Override
    public String toString() {
        return "Instructor [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", experience="
                + experience + ", photo=" + photo + "]";
    }

}