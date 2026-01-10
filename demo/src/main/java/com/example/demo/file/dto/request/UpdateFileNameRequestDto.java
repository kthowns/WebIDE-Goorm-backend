package com.example.demo.file.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateFileNameRequestDto {
    private String name;

    // TODO: 유효성 검증 어노테이션 추가
}

