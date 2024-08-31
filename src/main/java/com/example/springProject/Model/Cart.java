package com.example.springProject.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Products> products;

    @ManyToOne
    private Promotion promotion;

    @Column
    private Double totalPrice;
}
