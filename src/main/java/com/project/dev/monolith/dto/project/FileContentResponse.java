package com.project.dev.monolith.dto.project;

public record FileContentResponse(
        String path,
        String fileContent
) {
}
