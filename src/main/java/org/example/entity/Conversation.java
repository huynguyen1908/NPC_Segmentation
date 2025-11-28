package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Conversation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Column
//    private Integer questionId;
//    @Column
//    private Integer answerId;
    @Column
    private Integer userId;
    @Column
    private Integer groupId;
    @Column
    private String title;
}
