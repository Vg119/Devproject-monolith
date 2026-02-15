package com.project.dev.monolith.service.impl;

import com.project.dev.monolith.dto.subscription.CheckOutResponse;
import com.project.dev.monolith.dto.subscription.CheckoutRequest;
import com.project.dev.monolith.dto.subscription.PortalResponse;
import com.project.dev.monolith.dto.subscription.SubscriptionResponse;
import com.project.dev.monolith.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckOutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
