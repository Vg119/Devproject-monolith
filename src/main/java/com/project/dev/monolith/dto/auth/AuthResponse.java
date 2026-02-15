package com.project.dev.monolith.dto.auth;

public record AuthResponse(
        String token ,
        UserProfileResponse user) {


}
