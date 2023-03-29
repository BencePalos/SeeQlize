package com.bencep.seeqlize_backend.projects.dtos;

import com.bencep.seeqlize_backend.projects.models.ProjectTable;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private String projectName;
    @JsonFormat
    private List<ProjectTable> tables;

    private Long userID;

}
