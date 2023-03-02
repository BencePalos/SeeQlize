package com.bencep.seeqlize_backend.projects.models;

import com.bencep.seeqlize_backend.users.models.User;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "projects")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
