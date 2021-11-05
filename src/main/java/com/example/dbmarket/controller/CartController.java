package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Cart;
import com.example.dbmarket.entities.CartDetail;
import com.example.dbmarket.repository.CartDetailRepository;
import com.example.dbmarket.repository.CartRepository;

import com.example.dbmarket.service.CartDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/DBmarket")
public class CartController {
    @GetMapping("/cart")
    public String ShowCart(Model model) {
        List<CartDetail> cart = ;
        model.addAttribute("carts" , );
        return "views/content/cart";

    }


}
