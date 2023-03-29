package com.bencep.seeqlize_backend.projects.controllers;

import com.bencep.seeqlize_backend.common.ErrorResponseDto;
import com.bencep.seeqlize_backend.projects.dtos.ProjectDto;
import com.bencep.seeqlize_backend.projects.dtos.ProjectResponseDto;
import com.bencep.seeqlize_backend.projects.models.Project;
import com.bencep.seeqlize_backend.projects.models.ProjectTable;
import com.bencep.seeqlize_backend.projects.repositories.ProjectsRepository;
import com.bencep.seeqlize_backend.projects.services.ProjectsService;
import com.bencep.seeqlize_backend.users.models.User;
import com.bencep.seeqlize_backend.users.repositories.UserRepository;
import lombok.Getter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
@CrossOrigin
public class ProjectsController {

    public ProjectsService projectsService;
    public ProjectsRepository projectsRepository;
    public UserRepository userRepository;

    @Autowired
    public ProjectsController(ProjectsService projectsService, ProjectsRepository projectsRepository, UserRepository userRepository) {
        this.projectsService = projectsService;
        this.projectsRepository = projectsRepository;
        this.userRepository = userRepository;
    }


    @GetMapping
    public ResponseEntity getAllProjects(@RequestHeader(name = "userID") Long id){
        System.out.println(id);
        try{
            Optional<User> newUser = userRepository.findById(id);
            System.out.println(newUser);
            List<Project> allProjects = projectsRepository.findAllByUserId(id);
            System.out.println(allProjects);
            return ResponseEntity.status(200).body(allProjects);
        } catch(Exception e){
            return ResponseEntity.status(400).body(new ErrorResponseDto("No projects found"));
        }
    }

    @PostMapping
    public ResponseEntity addNewProject(@RequestBody ProjectDto projectDto, @RequestHeader(name = "id") Long id){
        projectDto.setUserID(id);
//        System.out.println(projectDto.getTables().get(0).getTableName());
//        System.out.println(projectDto.getTables().get(0).getColumns().get(0).getColumnName());
//        System.out.println(projectDto.getProjectName());
//        System.out.println(projectDto.getUserID());
        try{
            projectsService.saveNewProject(projectDto);
            return ResponseEntity.status(200).body(new ProjectResponseDto("Project saved"));
        }catch (ResponseStatusException ex){
            return ResponseEntity.status(400).body(ex.getReason());
        }
    }
}
