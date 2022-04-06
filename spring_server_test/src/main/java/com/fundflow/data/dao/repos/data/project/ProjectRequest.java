package com.fundflow.data.dao.repos.data.project;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectRequest {
    private String projName;
    private String projTeam;
    private String description;
    private int wantedMoney;
    private String category;
}
