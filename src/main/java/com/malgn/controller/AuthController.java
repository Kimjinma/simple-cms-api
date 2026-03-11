package com.malgn.controller;

import com.malgn.dto.request.LoginRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final com.malgn.configure.security.JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<com.malgn.dto.response.LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        UserDetails userDetails;
        
        try {
            userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if (!passwordEncoder.matches(loginRequest.getPassword(), userDetails.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String role = userDetails.getAuthorities().iterator().next().getAuthority();
        
        String token = jwtProvider.createToken(userDetails.getUsername(), role);

        return ResponseEntity.ok(new com.malgn.dto.response.LoginResponse(token));
    }
}
