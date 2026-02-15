package com.project.dev.monolith.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "projects",
        indexes = {
        @Index(name="idx_projects_updated_at_desc" , columnList = "updatedAt DESC,deletedAt"), @Index(name="idx_projects_updated_at_desc_reverse" , columnList = "deletedAt,updatedAt DESC")
,        @Index(name="idx_projects_deleted_at" , columnList = "deletedAt")
        }

)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;


//    @ManyToOne
//    @JoinColumn(name = "owner_id",nullable = false) // project must have owner ,hence nullable false
//    User owner;

    Boolean isPublic = false;

    @CreationTimestamp
    Instant createdAt;

    @UpdateTimestamp
    Instant updatedAt;

    @OneToMany(mappedBy = "project")
    private List<ProjectMember> projectMembers;


    Instant deletedAt; //soft delete . Dont permanently delete user from db. if null not deleted . If value , deleted
}
