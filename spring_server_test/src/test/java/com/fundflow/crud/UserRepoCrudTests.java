package com.fundflow.crud;

import com.fundflow.data.dao.repos.UserRepo;
import com.fundflow.data.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepoCrudTests {

    // TODO: Mock s3 storage when test it.

    @Autowired
    private UserRepo userRepo;

    private final User testUser = new User(
            "Test name",
            "test_email@gmail.com",
            "1111",
            "1111"
    );

    @AfterEach
    public void cleanRepo() {
        userRepo.deleteAll();
    }

    @Test
    public void insertAndReadIsCorrect() {
        var savedUser = userRepo.save(testUser);

        Assertions.assertEquals(savedUser, userRepo.findByToken(savedUser.getToken()));
        Assertions.assertEquals(savedUser, userRepo.findByEmail(savedUser.getEmail()));
        Assertions.assertEquals(savedUser, userRepo.findByUsername(savedUser.getUsername()));
        Assertions.assertEquals(savedUser, userRepo.findById(savedUser.getId()));
    }

    @Test
    public void insertAndDeleteIsCorrect() {
        var savedUser = userRepo.save(testUser);

        userRepo.delete(savedUser);

        Assertions.assertNull(userRepo.findByToken(savedUser.getToken()));
        Assertions.assertNull(userRepo.findByEmail(savedUser.getEmail()));
        Assertions.assertNull(userRepo.findByUsername(savedUser.getUsername()));
        Assertions.assertNull(userRepo.findById(savedUser.getId()));
    }

    @Test
    public void tokenUpdateIsCorrect() {
        var savedUser = userRepo.save(testUser);

        var oldToken = savedUser.getToken();
        var newToken = "2222";
        savedUser.setToken(newToken);
        userRepo.save(savedUser);

        Assertions.assertNull(userRepo.findByToken(oldToken));

        var updatedUser = userRepo.findByToken(newToken);
        Assertions.assertEquals(savedUser, updatedUser);
        Assertions.assertEquals(newToken, updatedUser.getToken());
    }

    @Test
    public void nameUpdateIsCorrect() {
        var savedUser = userRepo.save(testUser);

        var oldName = savedUser.getUsername();
        var newName = "tester2";
        savedUser.setUsername(newName);
        userRepo.save(savedUser);

        Assertions.assertNull(userRepo.findByUsername(oldName));

        var updatedUser = userRepo.findByUsername(newName);
        Assertions.assertEquals(savedUser, updatedUser);
        Assertions.assertEquals(newName, updatedUser.getUsername());
    }

    // TODO: Test email update
}
