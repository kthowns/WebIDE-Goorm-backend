package com.example.demo.filecontent.service;

import com.example.demo.filecontent.dto.request.SaveFileContentRequestDto;
import com.example.demo.filecontent.dto.response.FileContentResponseDto;

import java.util.List;

public interface FileContentService {
    // TODO: 파일 내용 저장
    FileContentResponseDto saveFileContent(SaveFileContentRequestDto requestDto);

    // TODO: 파일 내용 조회 (최신 버전)
    FileContentResponseDto getFileContent(Long fileId);

    // TODO: 특정 버전 파일 내용 조회
    FileContentResponseDto getFileContentByVersion(Long fileId, Integer version);

    // TODO: 파일 내용 버전 히스토리 조회
    List<FileContentResponseDto> getFileContentHistory(Long fileId);
}

