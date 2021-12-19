package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Product;
import com.example.dbmarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class ManageAdminController {
    @Autowired
    ProductService productService;

    @GetMapping("/admin/manage/product")
    public String showListProduct(Model model, Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        Page<Product> productPage = productService.findAll(pageable);

        return "";
    }
}
