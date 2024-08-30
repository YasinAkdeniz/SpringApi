package com.example.springProject.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String type;
}
