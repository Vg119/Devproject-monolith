package com.project.dev.monolith.service.impl;

import com.project.dev.monolith.dto.member.InviteMemberRequest;
import com.project.dev.monolith.dto.member.MemberResponse;
import com.project.dev.monolith.dto.member.UpdateMemberRoleRequest;
import com.project.dev.monolith.entity.Project;
import com.project.dev.monolith.entity.ProjectMember;
import com.project.dev.monolith.entity.ProjectMemberId;
import com.project.dev.monolith.entity.User;
import com.project.dev.monolith.enums.ProjectRole;
import com.project.dev.monolith.error.ResourceNotFoundException;
import com.project.dev.monolith.mapper.ProjectMemberMapper;
import com.project.dev.monolith.repository.ProjectMemberRepository;
import com.project.dev.monolith.repository.ProjectRepository;
import com.project.dev.monolith.repository.UserRepository;
import com.project.dev.monolith.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true,level= AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;
    UserRepository userRepository;

    @Override
    public List<MemberResponse> getProjectMembers(Long userId, Long projectId) {

        Project project = getAccessibleProjectById(userId,projectId);

        //for members

        return projectMemberRepository.findByIdProjectIdAndAcceptedAtIsNotNull(projectId)
                .stream()
                .map(projectMemberMapper::toProjectMemberResponseFromProjectMember)
                .toList();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        Project project = getAccessibleProjectById(userId,projectId);

        //validations
//        if(!project.getOwner().getId().equals(userId)){
//            throw new RuntimeException("Not allowed to invite member");
//        }

        User invitee = userRepository.findByUsername(request.username()).orElseThrow();

        if(invitee.getId().equals(userId)){
            throw new RuntimeException("Cannot invite yourself");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, invitee.getId());

        // if already invited - check if project member exists by invitee id
        if(projectMemberRepository.existsById(projectMemberId)){
            throw new  RuntimeException("Cannot invite once again");
        }

        ProjectMember member = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();

        projectMemberRepository.save(member);

        return projectMemberMapper.toProjectMemberResponseFromProjectMember(member);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, Long userId, UpdateMemberRoleRequest request) {

        Project project = getAccessibleProjectById(userId,projectId);

        //validations
//        if(!project.getOwner().getId().equals(userId)){
//            throw new RuntimeException("Not allowed to update member");
//        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();

        //check if project member has accepted the invite
        if(projectMember.getAcceptedAt()==null){
            throw new  RuntimeException("Invitation not accepted by member yet");
        }

        projectMember.setProjectRole(request.role());

        projectMemberRepository.save(projectMember); //just explicit saving for code readability , would be done even if skipped , as @Transaction is there and projec member dirtied


        return projectMemberMapper.toProjectMemberResponseFromProjectMember(projectMember);
    }

    @Override
    public MemberResponse acceptInviteByMember(Long projectId, Long memberId) {
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);

        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow(()->
                new  RuntimeException("Invitation does not exist"));

        if(projectMember.getAcceptedAt()!=null){
            throw new  RuntimeException("Invitation is already accepted");
        }

        projectMember.setAcceptedAt(Instant.now());

        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromProjectMember(projectMember);
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {
        Project project = getAccessibleProjectById(userId,projectId);

        //validations
//        if(!project.getOwner().getId().equals(userId)){
//            throw new RuntimeException("Not allowed to remove member");
//        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);

        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow(()->
                new  RuntimeException("Project member does not exist"));


        //check if project member has accepted the invite
        if(projectMember.getAcceptedAt()==null){
            throw new  RuntimeException("Invitation not accepted by member yet");
        }


        projectMemberRepository.deleteById(projectMemberId);
    }

    public Project getAccessibleProjectById(Long userId,Long id) {
        Project project = projectRepository.findAccessibleProjectById(userId,id, ProjectRole.OWNER).orElseThrow(()->new ResourceNotFoundException("project",id.toString()));

        return project;
    }

}
