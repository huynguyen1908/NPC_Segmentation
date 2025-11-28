package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Image extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String url;
    @Column
    private String description;

    @Column
    private Integer userId;

}
