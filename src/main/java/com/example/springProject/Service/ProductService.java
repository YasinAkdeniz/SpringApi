package com.example.springProject.Service;

import com.example.springProject.Entity.Products;
import com.example.springProject.Entity.User;
import com.example.springProject.Repository.ProductRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;


    public List<Products> getAllProduct() {
        return productRepo.findAll();
    }

    public Products getById(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    public Products addProduct(Products products) {
        return productRepo.save(products);
    }

    public Products updateProduct(Long id, Products product){
        Products products = productRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        products.setName(product.getName());
        products.setSku(product.getSku());
        products.setPrice(product.getPrice());
        products.setStockAmount(product.getStockAmount());

        return productRepo.save(products);
    }

    public Products deleteProduct(Long id) {
        Products products =  productRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("There is no user id : " + id)
        );
        productRepo.delete(products);
        return products;
    }

}
