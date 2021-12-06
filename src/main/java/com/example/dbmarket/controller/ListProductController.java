package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Product;
import com.example.dbmarket.entities.Supplier;
import com.example.dbmarket.service.ProductService;
import com.example.dbmarket.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ListProductController {
    @Autowired
    ProductService productService;
    @Autowired
    HttpSession session;
    @Autowired
    SupplierService supplierService;

    @GetMapping("supplier/listproduct")
    public String showListProduct(Model model) {
        Supplier supplier = (Supplier) session.getAttribute("supplier");
        List<Product> products = productService.findBySupplierId(supplier.getSupplierId());
        model.addAttribute("products", products);
        return "views/content/supplier/listproduct";
    }

    @RequestMapping("supplier/listProduct/delete/{id}")
    public String deleteProductList(@PathVariable("id") int id) {
        Supplier supplier = (Supplier) session.getAttribute("supplier");
        productService.delete(id);
        supplier = supplierService.findByEmail(supplier.getEmail()).orElse(null);
        session.setAttribute("supplier", supplier);
        return "redirect:/supplier/listproduct";
    }
}
