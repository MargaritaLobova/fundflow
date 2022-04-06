package com.fundflow.data.dao.api.user.response;

import lombok.Value;

@Value
public class UserCredentialsResponse {

    String token;
    String status;
    String message;
}
