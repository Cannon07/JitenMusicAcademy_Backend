package com.jpmware.JitenMusicAcademyBackend.service.user;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jpmware.JitenMusicAcademyBackend.dao.user.UserRepository;
import com.jpmware.JitenMusicAcademyBackend.entity.Role;
import com.jpmware.JitenMusicAcademyBackend.entity.User;

@Service
public class UserService implements UserDetailsService {

    private PasswordEncoder encoder;
    private UserRepository userRepository;

    @Autowired
    public UserService(
        PasswordEncoder encoder,
        UserRepository userRepository
    ) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("user is not valid"));
    }
    
}
