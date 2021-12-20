package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Order;
import com.example.dbmarket.entities.OrderDetail;
import com.example.dbmarket.entities.Supplier;
import com.example.dbmarket.service.OrderService;
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
public class InvoiceController {
    @Autowired
    OrderService orderService;
    @Autowired
    SupplierService supplierService;

    @Autowired
    HttpSession session;



    @GetMapping("supplier/invoice")
    public String showInvoice(int id, Model model) {
        Order order = orderService.findById(id).orElse(null);
        List<OrderDetail> orderDetails = order.getOrderDetails();
        double total = 0;
        for (OrderDetail orderDetail : orderDetails) {
            total += orderDetail.getTotalPrice();
        }
        model.addAttribute("total", total);
        model.addAttribute("orderDetails", orderDetails);
        model.addAttribute("order", order);
        return "views/PDF/invoiceSupplier";
    }

    @GetMapping("customer/invoice")
    public String showInvoiceC(int id, Model model) {
        Order order = orderService.findById(id).orElse(null);
        List<OrderDetail> orderDetails = order.getOrderDetails();
        double total = 0;
        for (OrderDetail orderDetail : orderDetails) {
            total += orderDetail.getTotalPrice();
        }
        model.addAttribute("total", total);
        model.addAttribute("orderDetails", orderDetails);
        model.addAttribute("order", order);
        return "views/PDF/invoice";
    }
}
