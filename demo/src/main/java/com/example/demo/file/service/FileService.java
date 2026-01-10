package com.example.demo.file.service;

import com.example.demo.file.dto.request.CreateFileRequestDto;
import com.example.demo.file.dto.request.UpdateFileNameRequestDto;
import com.example.demo.file.dto.response.FileResponseDto;
import com.example.demo.file.dto.response.FileTreeNodeDto;

import java.util.List;

public interface FileService {
    // TODO: 파일/폴더 생성
    FileResponseDto createFile(CreateFileRequestDto requestDto);

    // TODO: 파일 조회
    FileResponseDto getFile(Long fileId);

    // TODO: 프로젝트의 파일 트리 조회
    List<FileTreeNodeDto> getFileTree(Long projectId);

    // TODO: 파일명 수정
    FileResponseDto updateFileName(Long fileId, UpdateFileNameRequestDto requestDto);

    // TODO: 파일 삭제
    void deleteFile(Long fileId);
}

