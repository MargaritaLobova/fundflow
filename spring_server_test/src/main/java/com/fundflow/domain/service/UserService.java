package com.fundflow.domain.service;

import com.fundflow.data.dao.repos.UserRepo;
import com.fundflow.data.model.User;
import com.fundflow.domain.model.RegistrationCredential;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Transactional
    public User registerUser(RegistrationCredential credential) {
        if (userRepo.findByEmail(credential.getEmail()) != null) {
            throw new IllegalArgumentException("You are already registered!");
        } else {
            // TODO: Improve token implementation
            var user = new User(
                    credential.getUsername(),
                    credential.getEmail(),
                    credential.getPassword(),
                    getRandomString()
            );
            userRepo.save(user);
            return user;
        }
    }

    @Transactional
    public User authorizeUser(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("There is no such a user with such an email!");
        } else {
            if (user.getPassword().equals(password)) {
                // TODO: Improve token implementation
                var token = getRandomString();
                user.setToken(token);
                userRepo.save(user);
                return user;
            } else {
                throw new IllegalArgumentException("Not correct password");
            }
        }
    }

    private String getRandomString() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int number = random.nextInt(50);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    @Transactional
    public void logout(String token) {
        userRepo.findByToken(token).setToken(null);
    }
}
