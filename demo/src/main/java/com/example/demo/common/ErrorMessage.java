package com.example.demo.common;

public enum ErrorMessage {
    FILE_NOT_FOUND("파일을 찾을 수 없습니다."),
    FILE_READ_ERROR("파일을 읽을 수 없습니다."),
    FILE_WRITE_ERROR("파일을 저장할 수 없습니다."),
    INVALID_FILE_PATH("올바르지 않은 파일 경로입니다."),

    CODE_SAVE_ERROR("코드 저장에 실패했습니다."),
    CODE_FORMAT_ERROR("코드 형식이 올바르지 않습니다."),

    TERMINAL_COMMAND_ERROR("명령어 실행에 실패했습니다."),
    TERMINAL_ACCESS_DENIED("터미널 접근 권한이 없습니다."),

    CHAT_SEND_ERROR("메시지 전송에 실패했습니다."),
    CHAT_LOAD_ERROR("채팅 내역을 불러올 수 없습니다."),

    INVALID_CREDENTIALS("아이디 또는 비밀번호가 올바르지 않습니다."),
    USER_NOT_FOUND("사용자를 찾을 수 없습니다."),
    DUPLICATE_USER("이미 존재하는 사용자입니다."),
    INVALID_TOKEN("유효하지 않은 토큰입니다."),
    TOKEN_EXPIRED("토큰이 만료되었습니다."),
    UNAUTHORIZED("인증이 필요합니다."),

    INVALID_INPUT("입력값이 올바르지 않습니다."),
    REQUIRED_FIELD("필수 입력값이 누락되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}