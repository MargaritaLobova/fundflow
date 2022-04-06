package com.fundflow.domain.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class RegistrationCredential {

    @NonNull
    private String username;

    @NonNull
    private String email;

    @NonNull
    private String password;
}
