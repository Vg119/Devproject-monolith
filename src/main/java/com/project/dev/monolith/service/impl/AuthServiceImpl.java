package com.project.dev.monolith.service.impl;

import com.project.dev.monolith.dto.auth.AuthResponse;
import com.project.dev.monolith.dto.auth.LoginRequest;
import com.project.dev.monolith.dto.auth.SignupRequest;
import com.project.dev.monolith.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signup(SignupRequest signupRequest) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
