package com.fundflow.data.model;

import javax.persistence.*;
import java.util.List;

@Entity
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

    @OneToMany(mappedBy = "founder")
    private List<Project> usersProjects;

    @ManyToMany
    @JoinTable(
            name = "project_backers",
            joinColumns = @JoinColumn(name = "backer_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Project> getUsersProjects() {
        return usersProjects;
    }

    public void setUsersProjects(List<Project> usersProjects) {
        this.usersProjects = usersProjects;
    }

    public List<Project> getInvestedProjects() {
        return investedProjects;
    }

    public void setInvestedProjects(List<Project> investedProjects) {
        this.investedProjects = investedProjects;
    }
}
