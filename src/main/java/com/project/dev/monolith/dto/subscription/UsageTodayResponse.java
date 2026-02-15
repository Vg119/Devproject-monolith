package com.project.dev.monolith.dto.subscription;

public record UsageTodayResponse(
        Integer tokenUsed,
        Integer previewRunning,
        Integer previewsList,
        Integer tokensList
) {
}
