package com.example.demo.file.service;

import com.example.demo.file.dto.request.CreateFileRequestDto;
import com.example.demo.file.dto.request.UpdateFileNameRequestDto;
import com.example.demo.file.dto.response.FileResponseDto;
import com.example.demo.file.dto.response.FileTreeNodeDto;
import com.example.demo.file.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    @Override
    @Transactional
    public FileResponseDto createFile(CreateFileRequestDto requestDto) {
        // TODO: 파일/폴더 생성 로직 구현
        return null;
    }

    @Override
    public FileResponseDto getFile(Long fileId) {
        // TODO: 파일 조회 로직 구현
        return null;
    }

    @Override
    public List<FileTreeNodeDto> getFileTree(Long projectId) {
        // TODO: 파일 트리 조회 로직 구현
        return null;
    }

    @Override
    @Transactional
    public FileResponseDto updateFileName(Long fileId, UpdateFileNameRequestDto requestDto) {
        // TODO: 파일명 수정 로직 구현
        return null;
    }

    @Override
    @Transactional
    public void deleteFile(Long fileId) {
        // TODO: 파일 삭제 로직 구현
    }
}

