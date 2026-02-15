package com.project.dev.monolith.mapper;


import com.project.dev.monolith.dto.member.MemberResponse;
import com.project.dev.monolith.entity.Project;
import com.project.dev.monolith.entity.ProjectMember;
import com.project.dev.monolith.entity.User;
import com.project.dev.monolith.enums.ProjectRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(target = "projectRole" , constant = "OWNER")
    MemberResponse toProjectMemberResponse(User owner);

    @Mapping(source = "user.id", target = "id")
    @Mapping(target = "username",source = "user.username")
    @Mapping(target = "name",source = "user.name")
    MemberResponse toProjectMemberResponseFromProjectMember(ProjectMember projectMember);
}
