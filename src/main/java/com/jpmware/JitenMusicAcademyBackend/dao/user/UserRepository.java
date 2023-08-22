package com.jpmware.JitenMusicAcademyBackend.dao.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpmware.JitenMusicAcademyBackend.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    Optional<User> findByEmail(String email);

}
