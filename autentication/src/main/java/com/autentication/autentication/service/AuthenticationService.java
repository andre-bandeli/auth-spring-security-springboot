package com.autentication.autentication.service;

import com.autentication.autentication.config.JwtService;
import com.autentication.autentication.model.Role;
import com.autentication.autentication.model.auth.AuthenticantionResponse;
import com.autentication.autentication.model.auth.AuthenticationRequest;
import com.autentication.autentication.model.auth.RegisterRequest;
import com.autentication.autentication.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    private JwtService jwtService;

    private AuthenticationManager authenticationManager;

    public AuthenticantionResponse register(RegisterRequest request) {

        var user = User.builder()
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticantionResponse.builder().token(jwtToken).build();
    }

    public AuthenticantionResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticantionResponse.builder()
                .token(jwtToken).build();
    }
}
