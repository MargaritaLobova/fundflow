package com.fundflow.data.dao.api.project.response;

import lombok.Value;

@Value
public class CreateProjectResponse {

    int id;
    String status;
    String message;
}