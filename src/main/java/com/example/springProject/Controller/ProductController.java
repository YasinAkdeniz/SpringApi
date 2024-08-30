package com.example.springProject.Controller;

import com.example.springProject.Entity.Products;
import com.example.springProject.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    @ResponseBody
    public List<Products> allProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/products/{id}")
    @ResponseBody
    public Products getById(@PathVariable("id") Long id) {
        return productService.getById(id);
    }

    @PostMapping("/products/add")
    @ResponseBody
    public Products addProduct(@RequestBody Products products) {
        return productService.addProduct(products);
    }

    @PutMapping("/products/{id}")
    public Products updateProduct(@PathVariable("id") Long id, @RequestBody Products products) {
        return productService.updateProduct(id, products);

    }

    @DeleteMapping("/products/{id}")
    public Products deleteProduct(@PathVariable("id") Long id) {
        return productService.deleteProduct(id);
    }
}
