package com.example.demo.filecontent.repository;

import com.example.demo.filecontent.entity.FileContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileContentRepository extends JpaRepository<FileContent, Long> {
    // TODO: 파일별 최신 버전 조회
    Optional<FileContent> findFirstByFileIdOrderByVersionDesc(Long fileId);

    // TODO: 파일별 모든 버전 조회
    List<FileContent> findByFileIdOrderByVersionDesc(Long fileId);

    // TODO: 특정 버전 조회
    Optional<FileContent> findByFileIdAndVersion(Long fileId, Integer version);

    // TODO: 커스텀 쿼리 메서드 추가
}

