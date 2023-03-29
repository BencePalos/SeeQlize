package com.bencep.seeqlize_backend.projects.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "column")
@Table(name="columns")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TableColumn {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private ProjectTable table;

    @Column(name = "column_name")
    private String columnName;

    @Column(name = "column_type")
    private String columnType;


}
