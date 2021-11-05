package com.example.dbmarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/DBmarket")
public class CartController {
    @GetMapping("/cart")
    public String ShowCart() {
        return "views/content/cart";
    }


}
