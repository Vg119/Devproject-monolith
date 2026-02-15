package com.project.dev.monolith.mapper;

import com.project.dev.monolith.dto.project.ProjectResponse;
import com.project.dev.monolith.dto.project.ProjectSummaryResponse;
import com.project.dev.monolith.entity.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring") // component model is to tell it we r using spring framework here , so dependency injection can happen here and we dont need to create instances
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

    ProjectSummaryResponse toProjectSummaryResponse(Project project);

    List<ProjectSummaryResponse> toListofProjectSummaryResponse(List<Project> projects);
}
