package com.project.dev.monolith.repository;

import com.project.dev.monolith.entity.Project;
import com.project.dev.monolith.enums.ProjectRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("""
            SELECT p
            FROM Project p
            JOIN p.projectMembers pm
            WHERE pm.user.id = :userId
            AND pm.projectRole = :role
            AND p.deletedAt IS NULL
            ORDER BY p.updatedAt DESC
            """)
    List<Project> findAllAccessibleByUser(@Param("userId") Long userId , @Param("role") ProjectRole role);



    @Query("""
        SELECT p
        FROM Project p
        JOIN p.projectMembers pm
        WHERE pm.user.id = :userId
          AND p.id = :projectId
          AND pm.projectRole = :role
          AND p.deletedAt IS NULL
        """)
    Optional<Project> findAccessibleProjectById(
            Long userId,
            Long projectId,
            ProjectRole role
    );
}
