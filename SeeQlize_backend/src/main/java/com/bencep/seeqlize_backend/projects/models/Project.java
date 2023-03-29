package com.bencep.seeqlize_backend.projects.models;

import com.bencep.seeqlize_backend.users.models.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Entity(name = "project")
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

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy ="project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProjectTable> tables;
}
