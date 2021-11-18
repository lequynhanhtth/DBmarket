package com.example.dbmarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("supplier/dashboard")
    public String showDashboard(){
        return "views/content/supplier/dashboard";
    }
}
