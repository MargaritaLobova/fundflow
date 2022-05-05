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

    // TODO: Add project picture
    @Column
    private String category;

    @ManyToOne
    @JoinTable(name = "project_founder", joinColumns = @JoinColumn(name = "project_id"))
    private User founder;

    @ManyToMany
    @JoinTable(
            name = "project_backers",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "backer_id"))
    private List<User> backers;

    public Project() {
    }

    public Project(
            String projectName,
            String teamName,
            String description,
            int wantedMoney,
            User founder,
            String category
    ) {
        this.projectName = projectName;
        this.teamName = teamName;
        this.description = description;
        this.wantedMoney = wantedMoney;
        this.founder = founder;
        this.category = category;
    }
}
