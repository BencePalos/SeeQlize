package com.bencep.seeqlize_backend.users.repositories;

import com.bencep.seeqlize_backend.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByUsername(String username);
}
