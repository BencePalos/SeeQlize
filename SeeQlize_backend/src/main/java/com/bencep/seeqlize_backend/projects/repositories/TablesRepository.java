package com.bencep.seeqlize_backend.projects.repositories;

import com.bencep.seeqlize_backend.projects.models.ProjectTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface TablesRepository extends JpaRepository<ProjectTable, Long> {
}
