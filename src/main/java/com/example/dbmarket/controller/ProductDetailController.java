package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Product;
import com.example.dbmarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/DBmarket")
public class ProductDetailController {
    @Autowired
    ProductService productService;
    @Autowired
    HttpSession session;

    @GetMapping("/productdetail/{id}")
    public String getProductDetail(@PathVariable("id") int id, Model model) {
        Product product = productService.findById(id).get();
        Sort sort = Sort.by(Sort.Direction.DESC, "productId");

        //new product 1
        Pageable pageable = PageRequest.of(0, 3, sort);
        List<Product> newProducts = productService.findAll(pageable).getContent();
        model.addAttribute("newProducts1", newProducts);
        //new product 2
        pageable = PageRequest.of(1, 3, sort);
        newProducts = productService.findAll(pageable).getContent();
        model.addAttribute("newProducts2", newProducts);
        //new product 3
        pageable = PageRequest.of(2, 3, sort);
        newProducts = productService.findAll(pageable).getContent();
        model.addAttribute("newProducts3", newProducts);
        //product detail
        model.addAttribute("productDetail", product);
        pageable = PageRequest.of(0, 4);
        List<Product> products = productService.findByCategoryOrderByRate(product.getCategory().getCategoryId(), pageable).getContent();
        model.addAttribute("productdetails", products);
        model.addAttribute("newProducts", newProducts);
        return "views/content/productdetail";
    }

}
