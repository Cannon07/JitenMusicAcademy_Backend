package com.jpmware.JitenMusicAcademyBackend.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jpmware.JitenMusicAcademyBackend.dao.user.UserRepository;
import com.jpmware.JitenMusicAcademyBackend.dto.AuthenticationRequest;
import com.jpmware.JitenMusicAcademyBackend.dto.AuthenticationResponse;
import com.jpmware.JitenMusicAcademyBackend.dto.RegisterRequest;
import com.jpmware.JitenMusicAcademyBackend.entity.Role;
import com.jpmware.JitenMusicAcademyBackend.entity.User;

@Service
public class AuthenticationService {

    private UserRepository repository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    public AuthenticationService(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder,
        JwtService jwtService, 
        AuthenticationManager authenticationManager
    ) {
        repository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest request) {
        User user = new User(
            request.getFirst_name(),
            request.getLast_name(),
            request.getEmail(),
            passwordEncoder.encode(request.getPassword()),
            Role.ADMIN
        );
        repository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(), 
                request.getPassword())
        );
        User user = repository.findByEmail(request.getEmail())
            .orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }
    
}
