package com.bencep.seeqlize_backend.projects.repositories;

import com.bencep.seeqlize_backend.projects.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ProjectsRepository extends JpaRepository<Project, Long> {
}
