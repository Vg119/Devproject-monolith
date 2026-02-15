package com.project.dev.monolith.service;

import com.project.dev.monolith.dto.project.FileContentResponse;
import com.project.dev.monolith.dto.project.FileNode;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface FileService {
    List<FileNode> getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
