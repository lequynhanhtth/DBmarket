package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Order;
import com.example.dbmarket.entities.Product;
import com.example.dbmarket.entities.Supplier;
import com.example.dbmarket.service.OrderService;
import com.example.dbmarket.service.ProductService;
import com.example.dbmarket.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    HttpSession session;
    @Autowired
    SupplierService supplierService;
    @GetMapping("supplier/listOrder")
    public String showListProduct(Model model, Optional<Integer> page) {
        Supplier supplier = (Supplier) session.getAttribute("supplier");
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        Page<Order> orderPage = orderService.findAll(pageable);
        model.addAttribute("orderPage", orderPage);
        return "views/content/supplier/listorder";
    }

    @GetMapping("supplier/listOrder/cancel")
    public String doCancel(int id) {
        Order order = orderService.findById(id).orElse(null);
        order.setStatus("Canceled");
        orderService.save(order);
        return "redirect:/supplier/listOrder";
    }



}
