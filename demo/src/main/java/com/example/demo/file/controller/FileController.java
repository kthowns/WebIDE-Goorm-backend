package com.example.demo.file.controller;

import com.example.demo.file.dto.request.CreateFileRequestDto;
import com.example.demo.file.dto.request.UpdateFileNameRequestDto;
import com.example.demo.file.dto.response.FileResponseDto;
import com.example.demo.file.dto.response.FileTreeNodeDto;
import com.example.demo.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping
    public ResponseEntity<FileResponseDto> createFile(@RequestBody CreateFileRequestDto requestDto) {
        // TODO: 파일/폴더 생성 엔드포인트 구현
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping("/{fileId}")
    public ResponseEntity<FileResponseDto> getFile(@PathVariable Long fileId) {
        // TODO: 파일 조회 엔드포인트 구현
        return ResponseEntity.ok(null);
    }

    @GetMapping("/project/{projectId}/tree")
    public ResponseEntity<List<FileTreeNodeDto>> getFileTree(@PathVariable Long projectId) {
        // TODO: 파일 트리 조회 엔드포인트 구현
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{fileId}/name")
    public ResponseEntity<FileResponseDto> updateFileName(
            @PathVariable Long fileId,
            @RequestBody UpdateFileNameRequestDto requestDto) {
        // TODO: 파일명 수정 엔드포인트 구현
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{fileId}")
    public ResponseEntity<Void> deleteFile(@PathVariable Long fileId) {
        // TODO: 파일 삭제 엔드포인트 구현
        return ResponseEntity.noContent().build();
    }
}

