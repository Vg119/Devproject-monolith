package com.project.dev.monolith.repository;

import com.project.dev.monolith.entity.ProjectMember;
import com.project.dev.monolith.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

    List<ProjectMember> findByIdProjectIdAndAcceptedAtIsNotNull(Long projectId);
}
