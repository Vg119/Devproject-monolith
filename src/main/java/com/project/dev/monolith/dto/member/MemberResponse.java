package com.project.dev.monolith.dto.member;

import com.project.dev.monolith.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long id,
        String username,
        String name,
        ProjectRole projectRole,
        Instant invitedAt,
        Instant acceptedAt
) {
}
