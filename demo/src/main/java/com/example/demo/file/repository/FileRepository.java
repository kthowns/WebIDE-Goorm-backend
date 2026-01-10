package com.example.demo.file.repository;

import com.example.demo.file.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {
    // TODO: 프로젝트별 파일 조회
    List<FileEntity> findByProjectIdAndIsDeletedFalse(Long projectId);

    // TODO: 부모 폴더별 파일 조회
    List<FileEntity> findByParentIdAndIsDeletedFalse(Long parentId);

    // TODO: 커스텀 쿼리 메서드 추가
}

