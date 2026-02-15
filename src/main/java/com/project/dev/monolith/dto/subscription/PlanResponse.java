package com.project.dev.monolith.dto.subscription;

public record PlanResponse(
        Long  id,
        String name, //name like free,premium ,etc
        Integer maxProjects,//how many projects u can make
        Integer maxTokensPerDay,//maximum tokens according to plan
        //whenever u use the previewurl to view the app , the app runs in the kubernetes pod . So u want an upper limit on how many previews for a specific plan
        Boolean unlimitedAi,
        String price
) {
}
