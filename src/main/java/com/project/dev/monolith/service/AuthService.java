package com.project.dev.monolith.service;

import com.project.dev.monolith.dto.auth.AuthResponse;
import com.project.dev.monolith.dto.auth.LoginRequest;
import com.project.dev.monolith.dto.auth.SignupRequest;
import org.jspecify.annotations.Nullable;

public interface AuthService {

    AuthResponse signup(SignupRequest signupRequest);

    AuthResponse login(LoginRequest request);
}
