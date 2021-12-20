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
        model.addAttribute("productPage", productPage);
        return "views/content/admin/listProduct";
    }

    @GetMapping("/admin/manage/producstNotAccept")
    public String showProductsNotAccept(Model model, Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        Page<Product> productPage = productService.findProductNotAccept(pageable);
        model.addAttribute("productPage", productPage);
        return "views/content/admin/listProduct";
    }

    @GetMapping("/admin/manage/producstNotAccept/accept")
    public String acceptProduct(int id) {
        Product product = productService.findById(id).orElse(null);
        if(product.isAccept()){
            product.setAccept(false);
        }else{
            product.setAccept(true);
        }
        productService.save(product);
        return "redirect:/admin/manage/producstNotAccept";
    }

    @GetMapping("/admin/manage/edit")
    public String showEditProduct(int id, Model model) {
        Product product = productService.findById(id).orElse(null);
        model.addAttribute("product", product);
        return "views/content/admin/editProduct";
    }

}
