package com.bencep.seeqlize_backend.projects.services;

import com.bencep.seeqlize_backend.projects.dtos.ProjectDto;
import com.bencep.seeqlize_backend.projects.models.Project;
import com.bencep.seeqlize_backend.projects.models.ProjectTable;
import com.bencep.seeqlize_backend.projects.models.TableColumn;
import com.bencep.seeqlize_backend.projects.repositories.ColumnsRepository;
import com.bencep.seeqlize_backend.projects.repositories.ProjectsRepository;
import com.bencep.seeqlize_backend.projects.repositories.TablesRepository;
import com.bencep.seeqlize_backend.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectsServiceImpl implements ProjectsService {
    public UserRepository userRepository;
    public ProjectsRepository projectsRepository;
    public TablesRepository tablesRepository;
    public ColumnsRepository columnsRepository;

    @Autowired
    public ProjectsServiceImpl(UserRepository userRepository, ProjectsRepository projectsRepository, TablesRepository tablesRepository, ColumnsRepository columnsRepository) {
        this.userRepository = userRepository;
        this.projectsRepository = projectsRepository;
        this.tablesRepository = tablesRepository;
        this.columnsRepository = columnsRepository;
    }

    @Override
    public boolean saveNewProject(ProjectDto projectDto) {
        Project projectToSave = new Project();
        List<ProjectTable> projectTables = new ArrayList<>(projectDto.getTables());

        if (!projectDto.getProjectName().isEmpty()) {
            projectToSave.setProjectName(projectDto.getProjectName());
            projectToSave.setUser(userRepository.getReferenceById(projectDto.getUserID()));
            projectsRepository.save(projectToSave);

        }
        if(!projectTables.isEmpty()){
            for(ProjectTable table : projectTables){
                table.setProject(projectToSave);
                tablesRepository.save(table);
                if(!table.getColumns().isEmpty()) {
                    List<TableColumn> tableColumns = new ArrayList<>(table.getColumns());
                    for(TableColumn column : tableColumns){
                        columnsRepository.save(column);
                    }
                }

            }
            return true;
        }
        return false; //missing implementation
    }
}
