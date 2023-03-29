package com.bencep.seeqlize_backend.projects.repositories;

import com.bencep.seeqlize_backend.projects.models.TableColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ColumnsRepository extends JpaRepository<TableColumn, Long> {
}
