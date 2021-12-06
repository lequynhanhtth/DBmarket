package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Order;
import com.example.dbmarket.entities.Product;
import com.example.dbmarket.entities.Supplier;
import com.example.dbmarket.service.OrderService;
import com.example.dbmarket.service.ProductService;
import com.example.dbmarket.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    HttpSession session;
    @Autowired
    SupplierService supplierService;
    @GetMapping("supplier/listOrder")
    public String showListProduct(Model model) {
        Supplier supplier = (Supplier) session.getAttribute("supplier");
        List<Order> orders = orderService.findOrderBySupplierId(supplier.getSupplierId());
        model.addAttribute("orders",orders);
        return "views/content/supplier/listorder";
    }

}
