package com.fundflow.data.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
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
    //TODO project picture
    @Column
    private String category;

    @ManyToOne
    private User founder;

    @OneToMany
    private List<User> backers;

    public Project() {
    }

    public Project(String projectName, String teamName, String description, int wantedMoney, User user, String category) {
        setProjectName(projectName);
        setTeamName(teamName);
        setDescription(description);
        setWantedMoney(wantedMoney);
        setFounder(user);
        setCategory(category);
    }
}
