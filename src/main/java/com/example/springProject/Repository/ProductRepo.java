package com.example.springProject.Repository;

import com.example.springProject.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo  extends JpaRepository<Products, Long> {

}
