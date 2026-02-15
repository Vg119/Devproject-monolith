package com.project.dev.monolith.dto.auth;

public record UserProfileResponse(
        Long id,
        String username,
        String name
        //String avatarUrl
) {
}
