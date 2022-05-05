package com.fundflow.data.dao.api.project.response;

public class RenameProjectResponse {

    private final String status;
    private final String message;

    public RenameProjectResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
