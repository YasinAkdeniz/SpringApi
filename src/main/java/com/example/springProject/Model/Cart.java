package com.example.springProject.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @ManyToOne
    private Products products;

    @ManyToOne
    private Promotion promotion;

    @Column
    private Long totalPrice;
}
