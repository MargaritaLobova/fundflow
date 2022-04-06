package com.fundflow.data.dao.api.project;

import com.fundflow.data.dao.api.project.request.RenameProjectRequest;
import com.fundflow.data.dao.api.project.request.ProjectInfoRequest;
import com.fundflow.data.dao.api.project.response.ProjectInfoResponse;
import com.fundflow.data.dao.api.project.response.RenameProjectResponse;
import com.fundflow.domain.service.ProjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/api/v1/add-proj")
    public ProjectInfoResponse create(
            @RequestHeader(name = "User") String token,
            @RequestBody ProjectInfoRequest request
    ) {
        var id = projectService.create(
                token,
                request.getName(),
                request.getTeamName(),
                request.getDescription(),
                request.getWantedMoney(),
                request.getCategory()
        );
        return new ProjectInfoResponse(
                id,
                "OK",
                "Publication was added successfully"
        );
    }

    @PostMapping("/api/v1/rename-proj")
    public RenameProjectResponse rename(
            @RequestHeader(name = "User") String token,
            @RequestBody RenameProjectRequest request
    ) {

        projectService.rename(request.getNewName(), request.getId(), token);
        return new RenameProjectResponse("OK", "Publication was renamed successfully");
    }
}
