package com.project.dev.monolith.service;

import com.project.dev.monolith.dto.subscription.CheckOutResponse;
import com.project.dev.monolith.dto.subscription.CheckoutRequest;
import com.project.dev.monolith.dto.subscription.PortalResponse;
import com.project.dev.monolith.dto.subscription.SubscriptionResponse;
import org.jspecify.annotations.Nullable;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckOutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);

    PortalResponse openCustomerPortal(Long userId);
}
