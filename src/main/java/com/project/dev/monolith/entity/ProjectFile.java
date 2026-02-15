package com.project.dev.monolith.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ProjectFile {

    Long id;

    Project project;

    //this is the path where this file is to be kept .Using this the front end is going to build the project directory tree structure.
    String path;

    String minioObjectKey; // stores inside minIo object

    //many people access and modify our project . These are FK  to our User table
    User createdBy;
    User updatedBy;

}
