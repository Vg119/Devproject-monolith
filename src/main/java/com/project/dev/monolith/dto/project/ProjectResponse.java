package com.project.dev.monolith.dto.project;

import com.project.dev.monolith.dto.auth.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt
       // UserProfileResponse owner
) {
}
