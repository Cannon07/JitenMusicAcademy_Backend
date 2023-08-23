package com.jpmware.JitenMusicAcademyBackend.util;

import com.jpmware.JitenMusicAcademyBackend.dao.role.RoleRepository;
import com.jpmware.JitenMusicAcademyBackend.entity.Role;

public class UserRoleConverter {

    private RoleRepository roleRepository;

    public UserRoleConverter(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role fromString(String role) {
        if (role.equals("instructor")) {
            return roleRepository.findByAuthority("INSTRUCTOR").get();
        }
        return roleRepository.findByAuthority("STUDENT").get();
    }
    
}
