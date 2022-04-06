package com.fundflow.data.dao.repos.data.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserAuthorizationRequest {
    private String email;
    private String password;
}
