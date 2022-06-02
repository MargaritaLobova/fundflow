package com.fundflow.data.dao.api.user.response;

public class UserCredentialsResponse {

    private final String token;
    private final String status;
    private final String message;
    private final String username;

    public UserCredentialsResponse(String token, String status, String message, String username) {
        this.token = token;
        this.status = status;
        this.message = message;
        this.username = username;
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

    public String getUsername() {
        return username;
    }
}
