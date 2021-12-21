package com.example.dbmarket.controller;

import com.example.dbmarket.entities.OrderDetail;
import com.example.dbmarket.entities.Supplier;
import com.example.dbmarket.service.OrderDetailService;
import com.example.dbmarket.service.OrderService;
import com.example.dbmarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DashboardController {
    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    OrderService orderService;
    @Autowired
    HttpSession session;

    @GetMapping("supplier/dashboard")
    public String showDashboard(Model model) {
        Supplier supplier = (Supplier) session.getAttribute("supplier");
        Double totalPrice = orderDetailService.getTotalPriceBySupplierId(supplier.getSupplierId());
        Double numberProduct = orderDetailService.getNumberProductBySupplierId(supplier.getSupplierId());
        Double numberOrder = orderService.getNumberOrderDoneBySupplierId(supplier.getSupplierId());
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("numberProduct", numberProduct);
        model.addAttribute("numberOrder", numberOrder);

        return "views/content/supplier/dashboard";
    }
}
