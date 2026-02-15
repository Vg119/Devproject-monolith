package com.project.dev.monolith.service;

import com.project.dev.monolith.dto.subscription.PlanLimitsResponse;
import com.project.dev.monolith.dto.subscription.UsageTodayResponse;
import org.jspecify.annotations.Nullable;

public interface UsageService {

    UsageTodayResponse getTodayUsage(Long userId);

    PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
