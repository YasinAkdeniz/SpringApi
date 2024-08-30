package com.example.springProject.Service;

import com.example.springProject.Model.Cart;
import com.example.springProject.Model.Products;
import com.example.springProject.Model.User;
import com.example.springProject.Repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    CartRepo cartRepo;

    public Cart addCart(User user, Products products) {
        Cart cart = new  Cart();
        cart.setUser(user);
        cart.setProducts(products);
        cart.setTotalPrice(products.getPrice());

        return cartRepo.save(cart);
    }
}
