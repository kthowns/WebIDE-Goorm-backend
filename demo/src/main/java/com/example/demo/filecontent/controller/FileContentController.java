package com.example.demo.filecontent.controller;

import com.example.demo.filecontent.dto.request.SaveFileContentRequestDto;
import com.example.demo.filecontent.dto.response.FileContentResponseDto;
import com.example.demo.filecontent.service.FileContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/file-contents")
@RequiredArgsConstructor
public class FileContentController {

    private final FileContentService fileContentService;

    @PostMapping
    public ResponseEntity<FileContentResponseDto> saveFileContent(@RequestBody SaveFileContentRequestDto requestDto) {
        // TODO: 파일 내용 저장 엔드포인트 구현
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping("/file/{fileId}")
    public ResponseEntity<FileContentResponseDto> getFileContent(@PathVariable Long fileId) {
        // TODO: 파일 내용 조회 엔드포인트 구현 (최신 버전)
        return ResponseEntity.ok(null);
    }

    @GetMapping("/file/{fileId}/version/{version}")
    public ResponseEntity<FileContentResponseDto> getFileContentByVersion(
            @PathVariable Long fileId,
            @PathVariable Integer version) {
        // TODO: 특정 버전 파일 내용 조회 엔드포인트 구현
        return ResponseEntity.ok(null);
    }

    @GetMapping("/file/{fileId}/history")
    public ResponseEntity<List<FileContentResponseDto>> getFileContentHistory(@PathVariable Long fileId) {
        // TODO: 파일 내용 버전 히스토리 조회 엔드포인트 구현
        return ResponseEntity.ok(null);
    }
}

