package com.example.springProject.Controller;

import com.example.springProject.Model.Cart;
import com.example.springProject.Model.Products;
import com.example.springProject.Model.Promotion;
import com.example.springProject.Model.User;
import com.example.springProject.Repository.ProductRepo;
import com.example.springProject.Repository.PromotionRepo;
import com.example.springProject.Repository.UserRepo;
import com.example.springProject.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    PromotionRepo promotionRepo;

    @PostMapping("/addCart")
    public ResponseEntity <Cart> addCart(@RequestParam Long userId, @RequestParam List<Long> productIds,
                                        @RequestParam List<Integer> quantities, @RequestParam Long promotionId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        List<Products> productList = productRepo.findAllById(productIds);
        Promotion promotion = promotionRepo.findById(promotionId).orElseThrow(() -> new RuntimeException("Promotion not found"));

        Map<Long, Integer> productQuantities = new HashMap<>();
        for (int i = 0; i < productIds.size(); i++) {
            productQuantities.put(productIds.get(i), quantities.get(i));
        }

        Cart cart = cartService.addCart(user, productList, promotion, productQuantities);

        return ResponseEntity.ok(cart);
    }

}
