package com.fundflow.data.dao.api.project.response;

public class CreateProjectResponse {

    private final int id;
    private final String status;
    private final String message;

    public CreateProjectResponse(int id, String status, String message) {
        this.id = id;
        this.status = status;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
