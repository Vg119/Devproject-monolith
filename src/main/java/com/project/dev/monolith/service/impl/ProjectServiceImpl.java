package com.project.dev.monolith.service.impl;

import com.project.dev.monolith.dto.project.ProjectRequest;
import com.project.dev.monolith.dto.project.ProjectResponse;
import com.project.dev.monolith.dto.project.ProjectSummaryResponse;
import com.project.dev.monolith.entity.Project;
import com.project.dev.monolith.entity.ProjectMember;
import com.project.dev.monolith.entity.ProjectMemberId;
import com.project.dev.monolith.entity.User;
import com.project.dev.monolith.enums.ProjectRole;
import com.project.dev.monolith.error.ResourceNotFoundException;
import com.project.dev.monolith.mapper.ProjectMapper;
import com.project.dev.monolith.repository.ProjectMemberRepository;
import com.project.dev.monolith.repository.ProjectRepository;
import com.project.dev.monolith.repository.UserRepository;
import com.project.dev.monolith.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@Transactional // this makes all methods here transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper  projectMapper;
    ProjectMemberRepository  projectMemberRepository;


    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {

        //METHOD 1 - USE STREAM
/*        return projectRepository.findAllAccessibleByUser(userId)
                .stream()
                .map((project)->projectMapper.toProjectSummaryResponse(project))
                .collect(Collectors.toList());*/

        //METHOD 2 - USE MAPSTRUCT DIRECTLY
        var list = projectRepository.findAllAccessibleByUser(userId, ProjectRole.OWNER);
        return projectMapper.toListofProjectSummaryResponse(list);

    }

    @Override
    public ProjectResponse getUserProjectId(Long id, Long userId) {
        Project project = getAccessibleProjectById(userId,id);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        User owner = userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User",userId.toString()));

        Project project = Project.builder()
                .name(request.name())
                .isPublic(false)
                .build();

        project = projectRepository.save(project);

        //create a project member with role OWNER
        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(),userId);

        ProjectMember projectMember = ProjectMember.builder()
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .id(projectMemberId)
                .build();

        projectMemberRepository.save(projectMember);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {

        Project project = getAccessibleProjectById(userId,id);

//        if(!project.getOwner().getId().equals(userId)){
//            throw new RuntimeException("You are not allowed to update this project");
//        }

        project.setName(request.name());

        //project =  projectRepository.save(project); no need to explicitly save , as dirty check happens in a transaction
        //however , try to write this line as this improves readability to other developers

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id, Long userId) {

        Project project = getAccessibleProjectById(id,userId);

//        if(!project.getOwner().getId().equals(userId)){
//            throw new RuntimeException("You are not allowed to delete this project");
//        }

        //soft delete - only set deleted at . If deleted at is null , means not yet deleted
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);


    }

    //internal function

    public Project getAccessibleProjectById(Long id, Long userId) {
        Project project = projectRepository.findAccessibleProjectById(userId,id,ProjectRole.OWNER).orElseThrow(
                ()-> new ResourceNotFoundException("Project" , id.toString())
        );

        return project;
    }




}
