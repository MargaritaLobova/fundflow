package com.fundflow.data.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "user_info")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String token;
    @OneToMany
    private List<Project> usersProjects;
    @OneToMany
    private List<Project> investedProjects;

    public User() {
    }

    public User(String username, String email, String password, String token) {
        this.username = username;
        this.email = email;
        // TODO: Save only password hash
        this.password = password;
        this.token = token;
    }
}
