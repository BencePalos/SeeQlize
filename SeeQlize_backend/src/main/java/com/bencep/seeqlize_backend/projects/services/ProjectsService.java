package com.bencep.seeqlize_backend.projects.services;

import com.bencep.seeqlize_backend.projects.dtos.ProjectDto;
import org.springframework.stereotype.Service;

@Service
public interface ProjectsService {
    public boolean saveNewProject(ProjectDto projectDto);
}
