package com.fundflow.data.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String projectName;

    @Column
    private String teamName;

    @Column
    private String description;

    @Column
    private int wantedMoney;

    // TODO: Add project picture
    @Column
    private String category;

    @ManyToOne
    @JoinTable(name = "project_founder", joinColumns = @JoinColumn(name = "project_id"))
    private User founder;

    @ManyToMany
    @JoinTable(name = "project_backers", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "backer_id"))
    private List<User> backers;

    public Project() {
    }

    public Project(String projectName, String teamName, String description, int wantedMoney, String category, User founder) {
        this.projectName = projectName;
        this.teamName = teamName;
        this.description = description;
        this.wantedMoney = wantedMoney;
        this.category = category;
        this.founder = founder;
    }

    public int getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getDescription() {
        return description;
    }

    public int getWantedMoney() {
        return wantedMoney;
    }

    public String getCategory() {
        return category;
    }

    public User getFounder() {
        return founder;
    }

    public List<User> getBackers() {
        return backers;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWantedMoney(int wantedMoney) {
        this.wantedMoney = wantedMoney;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setFounder(User founder) {
        this.founder = founder;
    }

    public void setBackers(List<User> backers) {
        this.backers = backers;
    }
}
