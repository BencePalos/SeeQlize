package com.bencep.seeqlize_backend.projects.services;

import com.bencep.seeqlize_backend.projects.dtos.ProjectDto;
import com.bencep.seeqlize_backend.projects.models.Project;
import com.bencep.seeqlize_backend.projects.repositories.ProjectsRepository;
import com.bencep.seeqlize_backend.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectsServiceImpl implements ProjectsService{



    public UserRepository userRepository;
    public ProjectsRepository projectsRepository;
    @Autowired
    public ProjectsServiceImpl(UserRepository userRepository, ProjectsRepository projectsRepository) {
        this.userRepository = userRepository;
        this.projectsRepository = projectsRepository;
    }

    @Override
    public boolean saveNewProject(ProjectDto projectDto) {
        if (!projectDto.getProjectName().isEmpty()) {
            Project projectToSave = new Project();
            projectToSave.setProjectName(projectDto.getProjectName());
            projectToSave.setUser(userRepository.getReferenceById(projectDto.getUserID()));
            projectsRepository.save(projectToSave);
            return true;
        }
    return false; //missing implementation
    }
}
