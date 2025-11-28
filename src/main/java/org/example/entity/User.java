package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String role;
}
