package com.autentication.autentication.service;

import com.autentication.autentication.config.JwtService;
import com.autentication.autentication.model.Role;
import com.autentication.autentication.model.User;
import com.autentication.autentication.model.auth.AuthenticantionResponse;
import com.autentication.autentication.model.auth.AuthenticationRequest;
import com.autentication.autentication.model.auth.RegisterRequest;
import com.autentication.autentication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticantionResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticantionResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticantionResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticantionResponse.builder()
                .token(jwtToken)
                .build();
    }
}