package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Clob;
import java.util.List;

@Entity
@Data
public class Prompt extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String question;

    @Column
    private Integer imageId;

    @Column
    private List<Integer> answerId;

    @Column
    private Integer conversationId;

    @Column
    private int parentId;
}
