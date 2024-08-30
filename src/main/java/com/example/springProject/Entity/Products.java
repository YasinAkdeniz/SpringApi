package com.example.springProject.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name ="products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sku;

    @Column(nullable = false)
    private Long stockAmount;

    @Column(nullable = false)
    private Long price;

}
