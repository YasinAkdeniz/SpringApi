package com.example.springProject.Service;

import com.example.springProject.Enum.PromotionEnum;
import com.example.springProject.Model.Cart;
import com.example.springProject.Model.Products;
import com.example.springProject.Model.Promotion;
import com.example.springProject.Model.User;
import com.example.springProject.Repository.CartRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepo cartRepo;


    public Cart addCart(User user, List<Products> productsList, Promotion promotion) {
        Cart cart = new  Cart();
        cart.setUser(user);
        cart.setProducts(productsList);
        cart.setPromotion(promotion);

        Double totalPrice = 0.00;

        for (Products products : productsList) {
            totalPrice += products.getPrice();
        }
        cart.setTotalPrice(calculateTotalPrice(promotion, totalPrice));
        return cartRepo.save(cart);
    }

    public Double calculateTotalPrice(Promotion promotion, Double totalPrice)  {
       if (promotion.getType() == PromotionEnum.RATE) {
           totalPrice = (totalPrice / 100) * promotion.getDiscount();
       } else if (promotion.getType() == PromotionEnum.PRICE) {
           totalPrice = totalPrice - promotion.getDiscount();
       }
        System.out.println(totalPrice);

        return  totalPrice;

    }

    public Cart deleteCart(Long cartId) {
        Cart cart =  cartRepo.findById(cartId).orElseThrow(
                () -> new EntityNotFoundException("There is no cart id : " + cartId)
        );
        cartRepo.delete(cart);
        return cart;
    }
}
