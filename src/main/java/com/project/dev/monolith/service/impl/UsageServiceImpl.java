package com.project.dev.monolith.service.impl;

import com.project.dev.monolith.dto.subscription.PlanLimitsResponse;
import com.project.dev.monolith.dto.subscription.UsageTodayResponse;
import com.project.dev.monolith.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsage(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
