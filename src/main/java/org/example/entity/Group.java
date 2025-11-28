package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
//import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Group extends BaseEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

//    @Column
//    private List<Integer> conversations;

}
