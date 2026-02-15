package com.project.dev.monolith.controller;

import com.project.dev.monolith.dto.project.FileContentResponse;
import com.project.dev.monolith.dto.project.FileNode;
import com.project.dev.monolith.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/project/{projectId}/files")
public class FileController {


    private final FileService fileService;

    @GetMapping
    public ResponseEntity<List<FileNode>> getFileTree(@PathVariable Long projectId) {
        Long userId = 1l;
        return ResponseEntity.ok(fileService.getFileTree(projectId,userId));
    }

    @GetMapping("/{*path}") //this way u get the entire url part after / . So essentially the url becomes -/api/project/{projectId}/files/{path string}
    public ResponseEntity<FileContentResponse> getFile(
            @PathVariable Long projectId,
            @PathVariable String path
    )
    {
        Long userId = 1l;
        return ResponseEntity.ok(fileService.getFileContent(projectId,path,userId));
    }



}
