package com.project.dev.monolith.dto.member;

import com.project.dev.monolith.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull ProjectRole role) {
}
