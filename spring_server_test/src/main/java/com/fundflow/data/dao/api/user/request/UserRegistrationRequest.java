package com.fundflow.data.dao.api.user.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRegistrationRequest {

    private String username;
    private String email;
    private String password;
}
