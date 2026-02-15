package com.project.dev.monolith.controller;

import com.project.dev.monolith.dto.member.InviteMemberRequest;
import com.project.dev.monolith.dto.member.MemberResponse;
import com.project.dev.monolith.dto.member.UpdateMemberRoleRequest;
import com.project.dev.monolith.service.ProjectMemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/project/{projectId}/members")
public class ProjectMemberController {


    private final ProjectMemberService projectMemberService;


    @GetMapping
    public ResponseEntity<List<MemberResponse>> getProjectMembers(@PathVariable Long projectId) {
        Long userId = 1l;
        return ResponseEntity.ok(projectMemberService.getProjectMembers(userId,projectId));
    }

    @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(
          @PathVariable Long projectId,
          @RequestBody @Valid InviteMemberRequest request
    )
    {
        Long userId = 1l;
        return ResponseEntity.status(HttpStatus.CREATED).body(
                projectMemberService.inviteMember(projectId,request,userId)
        );

    }


    @PatchMapping("/acceptInvite/{memberId}")
    public ResponseEntity<MemberResponse> inviteAcceptByMember(
            @PathVariable Long projectId,
            @PathVariable Long memberId
    )
    {
        Long userId = 1l;
        return ResponseEntity.ok(projectMemberService.acceptInviteByMember(projectId,memberId));
    }



    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMemberRole(
            @PathVariable Long projectId,
            @PathVariable Long memberId,
            @RequestBody @Valid UpdateMemberRoleRequest request
    )
    {
        Long userId = 1l;
        return ResponseEntity.ok(projectMemberService.updateMemberRole(projectId,memberId,userId,request));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> removeProjectMember(
            @PathVariable Long projectId,
            @PathVariable Long memberId)
    {
        Long userId = 1l;
        projectMemberService.removeProjectMember(projectId,memberId,userId);
        return ResponseEntity.noContent().build();
    }



}
