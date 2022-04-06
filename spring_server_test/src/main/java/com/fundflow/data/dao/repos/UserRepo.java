package com.fundflow.data.dao.repos;

import com.fundflow.data.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
    User findByUsername(String username);

    User findById(int id);

    User findByEmail(String email);

    User findByToken(String token);
}
