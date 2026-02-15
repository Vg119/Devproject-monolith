package com.project.dev.monolith.service;

import com.project.dev.monolith.dto.auth.UserProfileResponse;
import org.jspecify.annotations.Nullable;

public interface UserService {

    UserProfileResponse getProfile(Long userId);
}
