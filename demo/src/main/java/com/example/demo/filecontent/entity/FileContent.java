package com.example.demo.filecontent.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "file_contents")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FileContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long fileId;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private Integer version;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // TODO: 생성자 및 비즈니스 로직 구현
}

