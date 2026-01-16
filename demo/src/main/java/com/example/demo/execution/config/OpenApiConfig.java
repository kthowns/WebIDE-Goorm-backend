package com.example.demo.execution.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
	info = @Info(
		title = "DeepFlow-WebIDE API",
		version = "v1",
		description = "DeepFlow 팀-WebIDE 프로젝트 API 명세서입니다.\n"
				+ "Java/Python 코드를 Docker 컨테이너에서 실행하는 API이며 REST /compile은 사용하지 않고 WebSocket만 지원합니다.\n\n"
				+ "### 인증\n"
				+ "- 로그인 후 발급받은 JWT를 요청에 포함해야 합니다.\n"
				+ "- WebSocket 핸드셰이크 요청 헤더에 Authorization: Bearer <token> 을 넣습니다.\n\n"
				+ "## WebSocket 사용법\n"
				+ "1) ws://localhost:8080/ws/compile 로 WebSocket 연결을 엽니다.\n"
				+ "2) 연결이 열린 뒤 start 메시지로 실행을 요청합니다.\n"
				+ "3) 실행 중 출력은 output 메시지로 스트리밍됩니다.\n"
				+ "4) 실행 종료 시 result 메시지가 도착합니다.\n"
				+ "5) 입력이 필요하면 input 메시지로 전달합니다.\n\n"
				+ "### 요청 메시지\n"
				+ "- start: {\"type\":\"start\",\"code\":\"...\",\"language\":\"java|python\",\"params\":[...]}\n"
				+ "  - code: 실행할 소스 코드\n"
				+ "  - language: java | python\n"
				+ "  - params: argv 배열\n"
				+ "- input: {\"type\":\"input\",\"data\":\"...\"}\n"
				+ "- stop: {\"type\":\"stop\"}\n\n"
				+ "### 응답 메시지\n"
				+ "- output: {\"type\":\"output\",\"stream\":\"stdout|stderr\",\"data\":\"...\"}\n"
				+ "  - stream: stdout | stderr\n"
				+ "  - data: 출력 데이터 (스트리밍)\n"
				+ "- result: {\"type\":\"result\",\"result\":\"성공|실패\",\"stdout\":\"...\",\"stderr\":\"...\",\"exitCode\":0,\"SystemOut\":\"...\",\"performance\":123,\"stage\":\"run\"}\n"
				+ "  - result: 성공 | 실패\n"
				+ "  - stdout: 표준 출력\n"
				+ "  - stderr: 표준 에러\n"
				+ "  - exitCode: 종료 코드\n"
				+ "  - SystemOut: 호환용 출력 필드\n"
				+ "  - performance: 실행 시간(ms)\n"
				+ "  - stage: run\n"
				+ "- error: {\"type\":\"error\",\"message\":\"...\"}\n"
				+ "  - message: 오류 메시지"
	),
	servers = {
		@Server(url = "https://t2.mobidic.shop", description = "배포 서버"),
		@Server(url = "http://localhost:8080", description = "로컬 개발 서버")
	}
)
public class OpenApiConfig {}
