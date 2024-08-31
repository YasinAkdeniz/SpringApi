package com.example.springProject.Service;

import com.example.springProject.Model.Cart;
import com.example.springProject.Model.Order;
import com.example.springProject.Repository.CartRepo;
import com.example.springProject.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    CartRepo cartRepo;

    public Order createOrder(Cart cart){
        Order order = new Order();

        order.setTotalAmount(cart.getTotalPrice());
        order.setMemberId(cart.getUser().getId());
        int productQuantity = cart.getProducts().size();
        order.setProductQuantity(productQuantity);
        order.setDiscount(cart.getPromotion().getDiscount());

        orderRepo.save(order);
        cartRepo.delete(cart);

        return order;
    }
}
