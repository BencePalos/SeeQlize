package com.bencep.seeqlize_backend.projects.services;

import com.bencep.seeqlize_backend.projects.dtos.ProjectDto;
import com.bencep.seeqlize_backend.projects.models.Project;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface ProjectsService {
    public boolean saveNewProject(ProjectDto projectDto);
    public Project getAllInfoByName(String name);
}
