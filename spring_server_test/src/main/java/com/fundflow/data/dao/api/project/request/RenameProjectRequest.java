package com.fundflow.data.dao.api.project.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RenameProjectRequest {

    private int id;
    private String newName;
}
