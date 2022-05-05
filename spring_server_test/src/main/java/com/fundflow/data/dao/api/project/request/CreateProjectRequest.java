package com.fundflow.data.dao.api.project.request;

public class CreateProjectRequest {

    private String name;
    private String teamName;
    private String description;
    private int wantedMoney;
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWantedMoney() {
        return wantedMoney;
    }

    public void setWantedMoney(int wantedMoney) {
        this.wantedMoney = wantedMoney;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
