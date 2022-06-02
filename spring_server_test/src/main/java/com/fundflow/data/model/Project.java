package com.fundflow.data.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    public Project(String projectName, String teamName, String description, int wantedMoney, String category
        , User founder, List<User> backers) {
        this.projectName = projectName;
        this.teamName = teamName;
        this.description = description;
        this.wantedMoney = wantedMoney;
        this.category = category;
        this.founder = founder;
        this.backers = backers;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;

        Project project = (Project) o;

        if (id != project.id) return false;
        if (wantedMoney != project.wantedMoney) return false;
        if (!projectName.equals(project.projectName)) return false;
        if (!teamName.equals(project.teamName)) return false;
        if (!Objects.equals(description, project.description))
            return false;
        if (!Objects.equals(category, project.category))
            return false;
        if (!founder.equals(project.founder)) return false;
        return Objects.equals(backers, project.backers);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + projectName.hashCode();
        result = 31 * result + teamName.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + wantedMoney;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + founder.hashCode();
        result = 31 * result + (backers != null ? backers.hashCode() : 0);
        return result;
    }
}
