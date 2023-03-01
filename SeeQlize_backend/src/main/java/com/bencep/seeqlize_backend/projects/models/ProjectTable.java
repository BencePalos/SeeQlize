package com.bencep.seeqlize_backend.projects.models;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.json.JSONObject;


@Entity
@Table(name="tables")
public class ProjectTable {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;

    @Column
    private String name;

    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private JSONObject tables;

}
