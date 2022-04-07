package com.fundflow.data.dao.api.project;

import com.fundflow.data.dao.api.project.request.RenameProjectRequest;
import com.fundflow.data.dao.api.project.request.ProjectInfoRequest;
import com.fundflow.data.dao.api.project.response.ProjectInfoResponse;
import com.fundflow.data.dao.api.project.response.RenameProjectResponse;
import com.fundflow.domain.service.ProjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/project")
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/create")
    public ProjectInfoResponse create(
            @RequestHeader(name = "Authorization") String token,
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

    @PostMapping("/rename")
    public RenameProjectResponse rename(
            @RequestHeader(name = "Authorization") String token,
            @RequestBody RenameProjectRequest request
    ) {

        projectService.rename(request.getNewName(), request.getId(), token);
        return new RenameProjectResponse("OK", "Publication was renamed successfully");
    }
}
