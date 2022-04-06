package com.fundflow.data.dao.repos.data.project;

import lombok.Value;

@Value
public class ProjectResponse {
    int publicationId;
    String status;
    String message;
}
