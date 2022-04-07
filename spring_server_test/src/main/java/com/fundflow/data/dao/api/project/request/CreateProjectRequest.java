package com.fundflow.data.dao.api.project.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateProjectRequest {

    private String name;
    private String teamName;
    private String description;
    private int wantedMoney;
    private String category;
}
