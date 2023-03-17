package com.bencep.seeqlize_backend.projects.services;

import com.bencep.seeqlize_backend.projects.dtos.ProjectDto;
import com.bencep.seeqlize_backend.projects.models.Project;
import com.bencep.seeqlize_backend.projects.repositories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectsServiceImpl implements ProjectsService{

    public ProjectsRepository projectsRepository;
    @Autowired
    public ProjectsServiceImpl(ProjectsRepository projectsRepository) {
        this.projectsRepository = projectsRepository;
    }

    @Override
    public boolean saveNewProject(ProjectDto projectDto) {
        if (!projectDto.getProjectName().isEmpty()) {
            Project projectToSave = new Project();
            projectToSave.setProjectName(projectDto.getProjectName());
            projectsRepository.save(projectToSave);
            return true;
        }
    return false; //missing implementation
    }
}
