package com.example.entity;


import jakarta.persistence.*;
import lombok.Data;

@Table(name = "TBL_USER")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @Column
    private String email;
}
