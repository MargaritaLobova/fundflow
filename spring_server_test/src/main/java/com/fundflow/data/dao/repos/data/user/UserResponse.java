package com.fundflow.data.dao.repos.data.user;

import lombok.Value;

@Value
public class UserResponse {
    String token;
    String status;
    String message;
}
