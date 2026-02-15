package com.project.dev.monolith.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

//FOR DIFFERENT TYPE OF PLANS LIKE FREE , PREMIUM ETC AND THEIR DETAILS
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Plan {

    Long  id;
    String name; //name like free,premium ,etc
    String stripePriceId; //for stripe to get the details abt the plan price
    Integer maxProjects;//how many projects u can make
    Integer maxTokensPerDay;//maximum tokens according to plan

    //whenever u use the previewurl to view the app , the app runs in the kubernetes pod . So u want an upper limit on how many previews for a specific plan
    Integer maxPreviews;
    Boolean unlimitedAi;

    // for admin , to make a plan active/inactive
    Boolean active;
}
