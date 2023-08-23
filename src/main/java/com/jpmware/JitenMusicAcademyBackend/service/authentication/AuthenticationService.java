package com.jpmware.JitenMusicAcademyBackend.service.authentication;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jpmware.JitenMusicAcademyBackend.dao.user.UserRepository;
import com.jpmware.JitenMusicAcademyBackend.dto.AuthenticationRequest;
import com.jpmware.JitenMusicAcademyBackend.dto.AuthenticationResponse;
import com.jpmware.JitenMusicAcademyBackend.dto.RegisterRequest;
import com.jpmware.JitenMusicAcademyBackend.entity.Role;
import com.jpmware.JitenMusicAcademyBackend.entity.User;
import com.jpmware.JitenMusicAcademyBackend.service.token.TokenService;
import com.jpmware.JitenMusicAcademyBackend.util.UserRoleConverter;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthenticationService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private TokenService tokenService;
    private UserRoleConverter userRoleConverter;

    @Autowired
    public AuthenticationService(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder, 
        AuthenticationManager authenticationManager,
        TokenService tokenService,
        UserRoleConverter userRoleConverter
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.userRoleConverter = userRoleConverter;
    }

    public User register(RegisterRequest request) {

        Role authority = userRoleConverter.fromString(request.getRole());
        Set<Role> authorities = new HashSet<>();
        authorities.add(authority);

        User user = new User(
            request.getFirst_name(),
            request.getLast_name(),
            request.getEmail(),
            passwordEncoder.encode(request.getPassword()),
            authorities
        );
        userRepository.save(user);
        return user;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        try {
            Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

            String token = tokenService.generateJwt(auth);
            return new AuthenticationResponse(userRepository.findByEmail(request.getEmail()).get(), token);

        } catch (AuthenticationException exception) {
            return new AuthenticationResponse(null, "");
        }
    }
    
}
