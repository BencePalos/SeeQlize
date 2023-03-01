package com.bencep.seeqlize_backend.projects.models;

import com.bencep.seeqlize_backend.users.models.User;
import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_name")
    private String projectName;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
