package com.example.springProject.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column
    private Long memberId;

    @Column
    private int productQuantity;

    @Column
    private Double totalAmount;

    @Column
    private double discount;
}
