package com.example.demo.filecontent.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SaveFileContentRequestDto {
    private Long fileId;
    private String content;

    // TODO: 유효성 검증 어노테이션 추가
}

