package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Category;
import com.example.dbmarket.entities.Product;
import com.example.dbmarket.service.CategoryService;
import com.example.dbmarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/DBmarket")
public class HomeController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @GetMapping("/Home")
    public String showHome(Model model) {
        List<Product> products = productService.findTop10OrderByDate();
        List<Category> categories = categoryService.findAll();
        List<Product> productList = productService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("categories",categories);
        model.addAttribute("productList",productList);
        return "views/content/home";
    }
}
