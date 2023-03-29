package com.bencep.seeqlize_backend.users.models;

import com.bencep.seeqlize_backend.projects.models.Project;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "user")
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    };
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @JsonManagedReference
    @OneToMany(mappedBy ="user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Project> projects;
}
