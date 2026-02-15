package com.project.dev.monolith.entity;

import com.project.dev.monolith.enums.PreviewStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Preview {

    Long id;
    Project project;

    String namespace;//so that resources in kubernetes r isolated
    String podName; //pod is the smallest unit in kubernetes
    String previewUrl; //where app is previewd when app is running on app

    Instant startedAt;
    Instant terminatedAt;

    Instant createdAt;

    PreviewStatus status;
}
