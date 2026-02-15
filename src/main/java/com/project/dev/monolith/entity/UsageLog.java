package com.project.dev.monolith.entity;

import com.project.dev.monolith.enums.MessageRole;

import java.time.Instant;

//this shows the usage log for each user . So that we can show them constantly .All info like the type of action , the tokens used , the duration , the metadata like which llm model was used , etc
public class UsageLog {

     Long id;
     User user;
     Project project;

     String action; // the action user was trying to perform
    Integer tokensUsed;
    Integer durationMs;

    String metaData; // Json of {model_used,prompt_used}

    Instant createdAt;

}
