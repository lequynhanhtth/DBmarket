package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Customer;
import com.example.dbmarket.entities.Supplier;
import com.example.dbmarket.service.CustomerService;
import com.example.dbmarket.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    CustomerService customerService;
    @Autowired
    HttpSession session;
    @Autowired
    SupplierService supplierService;
    @GetMapping("login")
    public String showLogin() {
        return "views/content/login";
    }
    @GetMapping("doLogin")
    public String doLogin(Model model, String email, String password, String isUser) {
        if (isUser.equals("User")) {
            Customer customer = customerService.findByEmail(email).orElse(null);
            if (customer != null) {
                if (password.equals(customer.getPassword())) {
                    session.setAttribute("customer",customer);
                    return "redirect:/DBmarket/Home";
                }else{
                    model.addAttribute("messageLogin", "Sai mật khẩu");
                    return "redirect:/login";
                }

            }else{
                model.addAttribute("messageLogin", "Tài khoản không tồn tại ");
                return "redirect:/login";
            }

        }else{
            Supplier supplier = supplierService.findByEmail(email).orElse(null);
            if(supplier != null){
                if(password.equals(supplier.getPassword())){
                    session.setAttribute("supplier",supplier);
                    return "redirect:/supplier/dashboard";
                }else{
                    model.addAttribute("messageLogin", "Sai mật khẩu");
                    return "redirect:/login";
                }

            }else{
                model.addAttribute("messageLogin", "Tài khoản không tồn tại ");
                return "redirect:/login";
            }
        }
    }
    @RequestMapping("/customer/logout")
    public String logout(){
        session.removeAttribute("customer");
        return "redirect:/DBmarket/Home";
    }

}
