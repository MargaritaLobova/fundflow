package com.fundflow.data.dao.api.project.response;

import com.fundflow.data.model.Project;
import java.util.List;

public class GetAllProjectsResponse {

  private final String status;
  private final List<Project> projects;

  public GetAllProjectsResponse(String status, List<Project> projects) {
    this.status = status;
    this.projects = projects;
  }

  public String getStatus() {
    return status;
  }

  public List<Project> getProjects() {
    return projects;
  }
}
