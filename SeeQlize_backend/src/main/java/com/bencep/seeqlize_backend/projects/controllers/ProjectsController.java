package com.bencep.seeqlize_backend.projects.controllers;

import com.bencep.seeqlize_backend.projects.dtos.ProjectDto;
import com.bencep.seeqlize_backend.projects.dtos.ProjectResponseDto;
import com.bencep.seeqlize_backend.projects.services.ProjectsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/projects")
@CrossOrigin
public class ProjectsController {

    public ProjectsService projectsService;

    @Autowired
    public ProjectsController(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }

    @PostMapping
    public ResponseEntity addNewProject(@RequestBody ProjectDto projectDto){
        try{
            projectsService.saveNewProject(projectDto);
            return ResponseEntity.status(200).body(new ProjectResponseDto("Project saved"));
        }catch (ResponseStatusException ex){
            return ResponseEntity.status(400).body(ex.getReason());
        }
    }
}
