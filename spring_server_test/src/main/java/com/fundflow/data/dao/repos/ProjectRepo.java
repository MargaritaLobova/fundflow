package com.fundflow.data.dao.repos;

import com.fundflow.data.model.Project;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepo extends CrudRepository<Project, Integer> {
    Project findByProjectName(String pubName);

    List<Project> getAllBy();

    Project findById(int id);
}
