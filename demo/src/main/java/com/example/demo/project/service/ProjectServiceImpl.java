package com.example.demo.project.service;

import com.example.demo.project.dto.request.CreateProjectRequestDto;
import com.example.demo.project.dto.response.ProjectResponseDto;
import com.example.demo.project.entity.Project;
import com.example.demo.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    @Transactional
    public ProjectResponseDto createProject(CreateProjectRequestDto requestDto) {
        Project project = Project.create(requestDto.getName(), requestDto.getDescription());

        ensureUniqueInviteCode(project);
        
        Project savedProject = projectRepository.save(project);

        return toResponseDto(savedProject);
    }

    @Override
    public ProjectResponseDto getProject(Long projectId) {
        Project project = projectRepository.findById(projectId)
            .orElseThrow(() -> new RuntimeException("프로젝트를 찾을 수 없습니다. ( id: " + projectId + ")"));

        return toResponseDto(project);
    }

    @Override
    public List<ProjectResponseDto> getAllProjects() {
        List<Project> projects = projectRepository.findAll();

        return projects.stream()
            .map(this::toResponseDto)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProjectResponseDto updateProject(Long projectId, CreateProjectRequestDto requestDto) {
        Project project = projectRepository.findById(projectId)
            .orElseThrow(() -> new RuntimeException("프로젝트를 찾을 수 없습니다. ( id: " + projectId + ")"));

        project.update(requestDto.getName(), requestDto.getDescription());

        Project updatedProject = projectRepository.save(project);

        return toResponseDto(updatedProject);
    }

    @Override
    @Transactional
    public void deleteProject(Long projectId) {
        Project project = projectRepository.findById(projectId)
            .orElseThrow(() -> new RuntimeException("프로젝트를 찾을 수 없습니다. ( id: " + projectId + ")"));

        projectRepository.delete(project);
    }

    private ProjectResponseDto toResponseDto(Project project) {
        return ProjectResponseDto.builder()
            .id(project.getId())
            .name(project.getName())
            .description(project.getDescription())
            //.ownerId(project.getOwnerId()) // 차후 확장
            .inviteCode(project.getInviteCode())
            .createdAt(project.getCreatedAt())
            .updatedAt(project.getUpdatedAt())
            .build();
    }

    @Override
    public ProjectResponseDto getProjectByInviteCode(String inviteCode) {
        Project project = projectRepository.findByInviteCode(inviteCode)
            .orElseThrow(() -> new RuntimeException("프로젝트를 찾을 수 없습니다. ( inviteCode: " + inviteCode + ")"));

        return toResponseDto(project);
    }

    // 고유 초대 코드 생성
    private void ensureUniqueInviteCode(Project project) {
        int maxRetries = 5; // 재시도 횟수 설정
        int retryCount = 0;
        int finalRetryCodeLength = 12; // 재시도 후 사용할 코드 길이

        while (retryCount < maxRetries) {
            project.generateInviteCode();
            if (!projectRepository.existsByInviteCode(project.getInviteCode())) {
                return;
            }
            retryCount++;
        }

        // 재시도 후에도 충돌 시 더 긴 코드 사용
        project.generateInviteCode(finalRetryCodeLength);
        while (projectRepository.existsByInviteCode(project.getInviteCode())) {
            project.generateInviteCode(finalRetryCodeLength);
        }
    }


}

