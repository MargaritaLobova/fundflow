package com.fundflow.data.dao.api.user;

import com.fundflow.data.dao.api.user.request.UserAuthorizationRequest;
import com.fundflow.data.dao.api.user.request.UserRegistrationRequest;
import com.fundflow.data.dao.api.user.response.UserCredentialsResponse;
import com.fundflow.domain.model.RegistrationCredential;
import com.fundflow.domain.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/v1/register")
    public UserCredentialsResponse registerUser(@RequestBody UserRegistrationRequest registerRequest) {
        var credential = registerRequestToRegistrationCredentials(registerRequest);
        var user = userService.registerUser(credential);
        var token = user.getToken();
        var username = user.getUsername();
        return new UserCredentialsResponse(token, "OK", "User was registered successfully",
            username);
    }

    @PostMapping("/api/v1/auth")
    public UserCredentialsResponse authoriseUser(@RequestBody UserAuthorizationRequest authenticationRequest) {
        var user = userService.authorizeUser(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        var token = user.getToken();
        var username = user.getUsername();
        return new UserCredentialsResponse(token, "OK", "User was authorized successfully",
            username);
    }

    @PostMapping("/api/v1/out")
    public void logout(@RequestHeader(name = "Authorization") String token) {
        userService.logout(token);
    }

    private RegistrationCredential registerRequestToRegistrationCredentials(UserRegistrationRequest request) {
        return new RegistrationCredential(
            request.getEmail(),
                request.getEmail(),
                request.getPassword()
        );
    }
}

