package com.example.springProject.Service;

import com.example.springProject.Enum.PromotionEnum;
import com.example.springProject.Model.Cart;
import com.example.springProject.Model.Products;
import com.example.springProject.Model.Promotion;
import com.example.springProject.Model.User;
import com.example.springProject.Repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    CartRepo cartRepo;


    public Cart addCart(User user, Products products, Promotion promotion) {
        Cart cart = new  Cart();
        cart.setUser(user);
        cart.setProducts(products);
        cart.setPromotion(promotion);
        cart.setTotalPrice(calculateTotalPrice(promotion, products.getPrice()));

        return cartRepo.save(cart);
    }

    public Long calculateTotalPrice(Promotion promotion, Long totalPrice)  {
       if (promotion.getType() == PromotionEnum.RATE) {
           totalPrice = (totalPrice / 100) * promotion.getDiscount();
       } else if (promotion.getType() == PromotionEnum.PRICE) {
           totalPrice = totalPrice - promotion.getDiscount();
       }
        System.out.println(totalPrice);

        return  totalPrice;

    }
}
