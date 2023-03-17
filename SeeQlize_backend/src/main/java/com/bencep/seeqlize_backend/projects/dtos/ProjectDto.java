package com.bencep.seeqlize_backend.projects.dtos;

import com.bencep.seeqlize_backend.projects.models.ProjectTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private String projectName;
    private List<ProjectTable> tables;

}
