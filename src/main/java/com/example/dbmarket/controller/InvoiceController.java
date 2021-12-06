package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Order;
import com.example.dbmarket.entities.OrderDetail;
import com.example.dbmarket.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InvoiceController {
    @Autowired
    OrderService orderService;
    @GetMapping("supplier/invoice")
    public String showInvoice(int id, Model model){
        Order order = orderService.findById(id).orElse(null);
        List<OrderDetail> orderDetails = order.getOrderDetails();
        double total = 0;
        for(OrderDetail orderDetail : orderDetails){
            total += orderDetail.getTotalPrice();
        }
        model.addAttribute("total",total);
        model.addAttribute("orderDetails",orderDetails);
        model.addAttribute("order", order);
        return "views/PDF/invoice";
    }
    @GetMapping("customer/invoice")
    public String showInvoiceC(int id, Model model){
        Order order = orderService.findById(id).orElse(null);
        List<OrderDetail> orderDetails = order.getOrderDetails();
        double total = 0;
        for(OrderDetail orderDetail : orderDetails){
            total += orderDetail.getTotalPrice();
        }
        model.addAttribute("total",total);
        model.addAttribute("orderDetails",orderDetails);
        model.addAttribute("order", order);
        return "views/PDF/invoice";
    }
}
