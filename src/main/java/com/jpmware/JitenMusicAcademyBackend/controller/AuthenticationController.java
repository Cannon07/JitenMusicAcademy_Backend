package com.jpmware.JitenMusicAcademyBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpmware.JitenMusicAcademyBackend.dto.AuthenticationRequest;
import com.jpmware.JitenMusicAcademyBackend.dto.AuthenticationResponse;
import com.jpmware.JitenMusicAcademyBackend.dto.RegisterRequest;
import com.jpmware.JitenMusicAcademyBackend.entity.User;
import com.jpmware.JitenMusicAcademyBackend.service.authentication.AuthenticationService;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {
    
    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register (
        @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate (
        @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
