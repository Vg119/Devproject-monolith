package com.project.dev.monolith.service;

import com.project.dev.monolith.dto.project.ProjectRequest;
import com.project.dev.monolith.dto.project.ProjectResponse;
import com.project.dev.monolith.dto.project.ProjectSummaryResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects(Long userId);

    ProjectResponse getUserProjectId(Long id, Long userId);

    ProjectResponse createProject(ProjectRequest request, Long userId);

    ProjectResponse updateProject(Long id, ProjectRequest request, Long userId);

    void softDelete(Long id, Long userId);
}
