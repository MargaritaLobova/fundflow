package com.fundflow.domain;

import com.fundflow.data.dao.repos.ProjectRepo;
import com.fundflow.data.dao.repos.UserRepo;
import com.fundflow.data.model.Project;
import com.fundflow.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private UserRepo userRepo;

    @Transactional
    public int addProject(String name, String team, String description, int wantedMoney, String token, String category) {
        User founder = userRepo.findByToken(token);
        Project project = new Project(name, team, description, wantedMoney, founder, category);
        projectRepo.save(project);
        return projectRepo.findByProjectName(name).getId();
    }

    @Transactional
    public int renameProject(String newName, int id, String token) {
        Project project = projectRepo.findById(id);
        User user = userRepo.findByToken(token);
        if (user != project.getFounder()) {
            throw new IllegalArgumentException("Access denied");
        } else {
            project.setProjectName(newName);
            projectRepo.save(project);
            return project.getId();
        }
    }
}
