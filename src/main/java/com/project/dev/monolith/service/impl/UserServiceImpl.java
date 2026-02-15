package com.project.dev.monolith.service.impl;

import com.project.dev.monolith.dto.auth.UserProfileResponse;
import com.project.dev.monolith.dto.subscription.PlanLimitsResponse;
import com.project.dev.monolith.dto.subscription.UsageTodayResponse;
import com.project.dev.monolith.service.UsageService;
import com.project.dev.monolith.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}
