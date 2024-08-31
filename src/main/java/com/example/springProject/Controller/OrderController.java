package com.example.springProject.Controller;

import com.example.springProject.Model.Cart;
import com.example.springProject.Model.Order;
import com.example.springProject.Repository.CartRepo;
import com.example.springProject.Service.CartService;
import com.example.springProject.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    CartRepo cartRepo;

    @Autowired
    CartService cartService;

    @PostMapping("/createOrder")
    public Order createOrder(@RequestParam Long cartId){
        Cart cart = cartRepo.findById(cartId).orElseThrow(()-> new RuntimeException("Böyle bir cart yok : " + cartId ));
        return  orderService.createOrder(cart);
    }
}
