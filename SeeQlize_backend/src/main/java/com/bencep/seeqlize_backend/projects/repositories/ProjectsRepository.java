package com.bencep.seeqlize_backend.projects.repositories;

import com.bencep.seeqlize_backend.projects.models.Project;
import com.bencep.seeqlize_backend.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProjectsRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByUserId(Long id);
    Project findProjectByProjectName(String name);

}
