package com.bencep.seeqlize_backend.projects.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.json.JSONObject;

import java.util.List;


@Entity(name = "table")
@Table(name="tables")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectTable {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @Column(name = "table_name")
    private String tableName;


    @JsonManagedReference
    @OneToMany(mappedBy ="table", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TableColumn> columns;

}
