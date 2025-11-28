package org.example.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Answer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String response;

    @Column
    private Integer promptId;

}
