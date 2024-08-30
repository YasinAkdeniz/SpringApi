package com.example.springProject.Repository;

import com.example.springProject.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo  extends JpaRepository<Products, Long> {

}
