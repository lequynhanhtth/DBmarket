package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Admin;
import com.example.dbmarket.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    HttpSession session;
    @RequestMapping("/showLoginAdmin")
    public String showLoginAdmin(){
        return "views/content/admin/login";
    }
    @GetMapping("/doLoginAdmin")
    public String doLoginAdmin(String email,String password){
        Admin admin = adminService.findByAdmin(email).orElse(null);
        if(admin != null){
            if(admin.getPassword().equals(password)){
                session.setAttribute("admin",admin);
                return "redirect:/admin/showDashboard";
            }
        }
        return "views/content/admin/login";
    }
    @GetMapping("/admin/showDashboard")
    public String showDashBoardAdmin(){


        return "views/content/admin/dashboard";
    }
}
