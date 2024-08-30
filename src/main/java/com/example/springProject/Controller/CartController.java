package com.example.springProject.Controller;

import com.example.springProject.Model.Cart;
import com.example.springProject.Model.Products;
import com.example.springProject.Model.User;
import com.example.springProject.Repository.ProductRepo;
import com.example.springProject.Repository.UserRepo;
import com.example.springProject.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ProductRepo productRepo;

    @PostMapping("/addCart")
    public ResponseEntity<Cart> addCart(@RequestParam Long userId, @RequestParam Long productId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Products products = productRepo.findById(productId).orElseThrow(()-> new RuntimeException("Product Not Fount"));
        Cart cart = cartService.addCart(user,products);

        return ResponseEntity.ok(cart);
    }
}
