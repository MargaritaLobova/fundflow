package com.fundflow.data.dao.api.user.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserAuthorizationRequest {

    private String email;
    private String password;
}
