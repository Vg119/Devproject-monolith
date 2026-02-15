package com.project.dev.monolith.entity;

import java.time.Instant;
//JOIN TABLE
public class ChatSession {

    Project project;

    User user;

    String title;

    Instant createdAt;
    Instant updatedAt;
    Instant deletedAt; //soft delete . Dont permanently delete user from db. if null not deleted . If value , deleted
}
