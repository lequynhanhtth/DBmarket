package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Cart;
import com.example.dbmarket.entities.CartDetail;
import com.example.dbmarket.entities.Customer;
import com.example.dbmarket.service.OrderDetailService;
import com.example.dbmarket.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CheckoutController {



    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailService orderDetailService;

    @RequestMapping("/user/cart/order")

    public String ShowOrder(Model model){
        Customer customers = new Customer();
        List<Cart> carts = customers.getCart();
        if(carts != null){
            Cart  cart = carts.get(carts.size()-1);

            List<CartDetail> cartDetails = cart.getCartDetails();

            model.addAttribute("cartDetails" , cartDetails);

            model.addAttribute("cart" , cart);
        }

    return "views/content/checkout";
    }
}
