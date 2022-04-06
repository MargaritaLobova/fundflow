package com.fundflow.data.dao.api;

import com.fundflow.data.dao.repos.data.project.ProjectRenameRequest;
import com.fundflow.data.dao.repos.data.project.ProjectRequest;
import com.fundflow.data.dao.repos.data.project.ProjectResponse;
import com.fundflow.domain.ProjectService;
import com.fundflow.data.dao.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/api/v1/add-proj")
    public ProjectResponse addProject(@RequestHeader(name = "User") String token,
                                      @RequestBody ProjectRequest request) {
        return new ProjectResponse(
                projectService.addProject(projRequestToProjName(request), projRequestToProjTeam(request), projRequestToProjDesc(request), projRequestToProjWantedMoney(request), token, projRequestToProjCategory(request)), "OK", "Publication was added successfully");
    }

    private String projRequestToProjName(ProjectRequest request) {
        return request.getProjName();
    }

    private String projRequestToProjTeam(ProjectRequest request) {
        return request.getProjTeam();
    }

    private String projRequestToProjDesc(ProjectRequest request) {
        return request.getDescription();
    }

    private int projRequestToProjWantedMoney(ProjectRequest request) {
        return request.getWantedMoney();
    }

    private String projRequestToProjCategory(ProjectRequest request) {
        return request.getCategory();
    }

    @PostMapping("/api/v1/rename-proj")
    public ProjectResponse renameProject(@RequestHeader(name = "User") String token,
                                         @RequestBody ProjectRenameRequest request) {
        return new ProjectResponse(
                projectService.renameProject(request.getNewName(), request.getId(), token), "OK", "Publication was renamed successfully");
    }
}
