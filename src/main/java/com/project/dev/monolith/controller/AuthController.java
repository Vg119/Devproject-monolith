package com.project.dev.monolith.controller;

import com.project.dev.monolith.dto.auth.AuthResponse;
import com.project.dev.monolith.dto.auth.LoginRequest;
import com.project.dev.monolith.dto.auth.SignupRequest;
import com.project.dev.monolith.dto.auth.UserProfileResponse;
import com.project.dev.monolith.service.AuthService;
import com.project.dev.monolith.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(makeFinal = true , level = AccessLevel.PRIVATE)
public class AuthController {

    AuthService authService;
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest signupRequest)
    {
        return ResponseEntity.ok(authService.signup(signupRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile()
    {
        Long userId = 1l;

        return ResponseEntity.ok(userService.getProfile(userId));
    }


}
