package com.jpmware.JitenMusicAcademyBackend.util;

import com.jpmware.JitenMusicAcademyBackend.entity.Role;

public class UserRoleConverter {

    public Role fromString(String role) {
        switch(role) {
            case "instructor":
                return Role.ROLE_INSTRUCTOR;
            case "student":
                return Role.ROLE_STUDENT;
            default:
                return Role.ROLE_ADMIN;
        }
    }
    
}
