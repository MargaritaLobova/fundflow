package com.fundflow.data.dao.api.user.response;

public class UserCredentialsResponse {

    private final String token;
    private final String status;
    private final String message;

    public UserCredentialsResponse(String token, String status, String message) {
        this.token = token;
        this.status = status;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
