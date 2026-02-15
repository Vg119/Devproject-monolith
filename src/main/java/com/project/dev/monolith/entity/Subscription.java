package com.project.dev.monolith.entity;

import com.project.dev.monolith.enums.SubscriptionStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Subscription {

    Long id;
    User user;//FK
    Plan plan;//FK
    String stripeCustomerId;//for each customer ,stripe gives an id . U store this id here
    String stripeSubscriptionId;//see subscription on stripe dashboard
    //when subscription starts and ends. End is updated if subscription increased.
    Instant currentPeriodStart;
    Instant currentPeriodEnd;
    //if cancellable after subscription ends , by default false.
    Boolean cancelAtPeriodEnd = false;


    SubscriptionStatus status; //enum
    Instant createdAt;
    Instant updatedAt;

}
