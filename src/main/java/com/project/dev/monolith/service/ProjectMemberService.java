package com.project.dev.monolith.service;

import com.project.dev.monolith.dto.member.InviteMemberRequest;
import com.project.dev.monolith.dto.member.MemberResponse;
import com.project.dev.monolith.dto.member.UpdateMemberRoleRequest;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long userId, Long projectId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

    MemberResponse updateMemberRole(Long projectId, Long memberId, Long userId, UpdateMemberRoleRequest request);

    MemberResponse acceptInviteByMember(Long projectId, Long memberId);

    void removeProjectMember(Long projectId, Long memberId, Long userId);
}
