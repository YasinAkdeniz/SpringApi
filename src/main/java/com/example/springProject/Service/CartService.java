package com.example.springProject.Service;

import com.example.springProject.Enum.PromotionEnum;
import com.example.springProject.Model.*;
import com.example.springProject.Repository.CartRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    CartRepo cartRepo;


    public Cart addCart(User user, List<Products> productList, Promotion promotion, Map<Long, Integer> productQuantities) {
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setPromotion(promotion);

        List<CartItem> items = productList.stream().map(product -> {
            CartItem item = new CartItem();
            item.setProducts(product);
            item.setQuantity(productQuantities.get(product.getId()));
            item.setCart(cart);  // CartItem'ı Cart ile ilişkilendiriyoruz
            return item;
        }).collect(Collectors.toList());

        cart.setItems(items);

        double totalPrice = 0.00;

        for (CartItem item : items) {
            totalPrice += item.getProducts().getPrice() * item.getQuantity();
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

    public void deleteCart(Long cartId) {
        Cart cart =  cartRepo.findById(cartId).orElseThrow(
                () -> new EntityNotFoundException("There is no cart id : " + cartId)
        );
        cartRepo.delete(cart);
    }
}
