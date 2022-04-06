package com.fundflow.data.dao.repos;

import com.fundflow.data.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepo extends CrudRepository<Project, Integer> {
    Project findByProjectName(String pubName);

    Project findById(int id);
}
