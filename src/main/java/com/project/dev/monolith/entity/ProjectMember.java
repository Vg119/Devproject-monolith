package com.project.dev.monolith.entity;

import com.project.dev.monolith.enums.ProjectRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
//A join table for user and project , no pk of its own .
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="project_members")
public class ProjectMember {

    //combined pk of pks of user and project
    @EmbeddedId
    ProjectMemberId id;

   @ManyToOne
   @MapsId("projectId")
    Project project;


    @ManyToOne
    @MapsId("userId")
    User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ProjectRole projectRole;

    Instant invitedAt;
    Instant acceptedAt;
}
