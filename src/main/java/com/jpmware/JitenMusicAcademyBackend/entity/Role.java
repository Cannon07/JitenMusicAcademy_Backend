package com.jpmware.JitenMusicAcademyBackend.entity;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;

    @Column(name = "authority")
    private String authority;

    // Constructors

    public Role() {
        super();
    }

    public Role(String authoriry) {
        this.authority = authoriry;
    } 

    public Role(Integer id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    // Getters and Setters

    @Override
    public String getAuthority() {
        return authority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
