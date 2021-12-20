package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Customer;
import com.example.dbmarket.entities.Order;
import com.example.dbmarket.service.CustomerService;
import com.example.dbmarket.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ProfileController {
    @Autowired
    CustomerService customerService;
    @Autowired
    OrderService orderService;
    @Autowired
    HttpSession session;

    @RequestMapping("customer/profile")
    public String showProfile(Model model) {
        Customer customerold = (Customer) session.getAttribute("customer");
        customerold = customerService.findById(customerold.getCustomerId()).orElse(null);
        model.addAttribute("customer", customerold);
        return "views/content/profile";
    }

    @RequestMapping("customer/profile/update")
    public String updateProfile(Customer customer) {
        Customer customerold = (Customer) session.getAttribute("customer");
        customerold = customerService.findById(customerold.getCustomerId()).orElse(null);
        customerold.setAddress(customer.getAddress());
        customerold.setEmail(customer.getEmail());
        customerold.setFullname(customer.getFullname());
        customerold.setPhone(customer.getPhone());
        customerService.save(customerold);
        return "redirect:/customer/profile";
    }

    @GetMapping("customer/changepassword")
    public String showChangePassword(Model model) {
        Customer customerold = (Customer) session.getAttribute("customer");
        customerold = customerService.findById(customerold.getCustomerId()).orElse(null);
        model.addAttribute("customer", customerold);
        return "views/content/changepassword";
    }

    @PostMapping("customer/changepassword")
    public String changePassword(String newPassword) {
        Customer customerold = (Customer) session.getAttribute("customer");
        customerold = customerService.findById(customerold.getCustomerId()).orElse(null);
        customerold.setPassword(newPassword);
        customerService.save(customerold);
        return "redirect:/customer/changepassword";
    }

    @GetMapping("customer/listOrder")
    public String showListOrder(Model model) {
        Customer customer = (Customer) session.getAttribute("customer");
        customer = customerService.findById(customer.getCustomerId()).orElse(null);
        model.addAttribute("orders", customer.getOrders());
        return "views/content/listOrder";
    }

    @GetMapping("customer/listOrder/cancel")
    public String doCancel(int id) {
        Order order = orderService.findById(id).orElse(null);
        order.setStatus("Canceled");
        orderService.save(order);
        return "redirect:/customer/listOrder";
    }
    @GetMapping("customer/listOrder/accept")
    public String doAccept(int id){
        Order order = orderService.findById(id).orElse(null);
        order.setStatus("Waiting to ship");
        orderService.save(order);
        return "redirect:/customer/listOrder";
    }
}
