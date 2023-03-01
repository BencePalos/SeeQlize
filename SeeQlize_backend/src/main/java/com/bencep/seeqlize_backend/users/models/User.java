package com.bencep.seeqlize_backend.users.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
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
}
