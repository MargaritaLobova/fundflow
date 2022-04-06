package com.fundflow.data.dao.repos.data.project;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectRenameRequest {
    private int id;
    private String newName;
}
