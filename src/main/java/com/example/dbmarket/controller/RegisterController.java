package com.example.dbmarket.controller;

import com.example.dbmarket.service.CustomerService;
import com.example.dbmarket.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {
    @Autowired
    CustomerService customerService;
    @Autowired
    HttpSession session;
    @Autowired
    SupplierService supplierService;
    @GetMapping("register")
    public String showRegister() {
        return "views/content/register";
    }



}
