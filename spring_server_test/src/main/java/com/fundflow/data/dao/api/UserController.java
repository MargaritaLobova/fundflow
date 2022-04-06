package com.fundflow.data.dao.api;

import com.fundflow.data.dao.repos.data.user.UserAuthorizationRequest;
import com.fundflow.data.dao.repos.data.user.UserRegistrationRequest;
import com.fundflow.data.dao.repos.data.user.UserResponse;
import com.fundflow.data.model.User;
import com.fundflow.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/v1/register")
    public UserResponse registerUser(@RequestBody UserRegistrationRequest registerRequest) {
        User user = registerRequestToUser(registerRequest);
        return new UserResponse(userService.registerUser(user), "OK", "User was registered successfully");
    }

    @PostMapping("/api/v1/auth")
    public UserResponse authoriseUser(@RequestBody UserAuthorizationRequest authenticationRequest) {
        User user = userService.authorizeUser(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        return new UserResponse(user.getToken(), "OK", "User was authorized successfully");
    }

    @PostMapping("/api/v1/out")
    public UserResponse logout(@RequestHeader(name = "Authorization") String token) {
        userService.logout(token);
        return new UserResponse(null, "OK", "User was log out successfully");
    }

    private User registerRequestToUser(UserRegistrationRequest request) {
        return new User(request.getUsername(),
                request.getEmail(),
                request.getPassword());
    }
}

