package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Category;
import com.example.dbmarket.entities.Product;
import com.example.dbmarket.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/DBmarket")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/Category")
    public String showCategory(String categoryId, Integer pageNumber, Model model) {
        Category category = categoryService.findById(categoryId).orElse(null);
        List<Product> productList = category.getProducts();
        List<Product> products = new ArrayList<>();
            int pageMax = (int) Math.ceil(productList.size() / 12.0);
            if (pageNumber == null) pageNumber = 1;
            if(productList.size() == 0) pageMax =1;
            if (pageNumber == pageMax) {
                for (int i = (pageMax - 1) * 12; i < productList.size(); i++) {
                    products.add(productList.get(i));
                }

            } else {
                for (int i = (pageNumber - 1) * 12; i < pageNumber * 12; i++) {
                    products.add(productList.get(i));
                }
            }

        model.addAttribute("categoryId",categoryId);
        model.addAttribute("pageMax",pageMax);
        model.addAttribute("pageNumber",pageNumber);
        model.addAttribute("products", products);
        return "views/content/category";
    }

}
