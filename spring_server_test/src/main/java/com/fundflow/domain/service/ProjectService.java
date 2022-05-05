package com.fundflow.domain.service;

import com.fundflow.data.dao.repos.ProjectRepo;
import com.fundflow.data.dao.repos.UserRepo;
import com.fundflow.data.model.Project;
import com.fundflow.data.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProjectService {

    private final ProjectRepo projectRepo;
    private final UserRepo userRepo;

    public ProjectService(ProjectRepo projectRepo, UserRepo userRepo) {
        this.projectRepo = projectRepo;
        this.userRepo = userRepo;
    }

    @Transactional
    public int create(String token, String name, String team, String description, int wantedMoney, String category) {
        User founder = userRepo.findByToken(token);
        Project project = new Project(name, team, description, wantedMoney, category, founder);
        projectRepo.save(project);
        return projectRepo.findByProjectName(name).getId();
    }

    @Transactional
    public void rename(String token, int id, String newName) {
        User user = userRepo.findByToken(token);
        Project project = projectRepo.findById(id);
        if (user != project.getFounder()) {
            throw new IllegalArgumentException("Access denied");
        } else {
            project.setProjectName(newName);
            projectRepo.save(project);
        }
    }
}
