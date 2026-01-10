package com.example.demo.filecontent.service;

import com.example.demo.filecontent.dto.request.SaveFileContentRequestDto;
import com.example.demo.filecontent.dto.response.FileContentResponseDto;
import com.example.demo.filecontent.repository.FileContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FileContentServiceImpl implements FileContentService {

    private final FileContentRepository fileContentRepository;

    @Override
    @Transactional
    public FileContentResponseDto saveFileContent(SaveFileContentRequestDto requestDto) {
        // TODO: 파일 내용 저장 로직 구현
        return null;
    }

    @Override
    public FileContentResponseDto getFileContent(Long fileId) {
        // TODO: 파일 내용 조회 로직 구현 (최신 버전)
        return null;
    }

    @Override
    public FileContentResponseDto getFileContentByVersion(Long fileId, Integer version) {
        // TODO: 특정 버전 파일 내용 조회 로직 구현
        return null;
    }

    @Override
    public List<FileContentResponseDto> getFileContentHistory(Long fileId) {
        // TODO: 파일 내용 버전 히스토리 조회 로직 구현
        return null;
    }
}

