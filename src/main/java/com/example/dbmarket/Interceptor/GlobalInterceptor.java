package com.example.dbmarket.Interceptor;

import com.example.dbmarket.entities.Category;
import com.example.dbmarket.entities.Customer;
import com.example.dbmarket.service.CategoryService;
import com.example.dbmarket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Component
public class GlobalInterceptor implements HandlerInterceptor {
    @Autowired
    HttpSession session;
    @Autowired
    CategoryService categoryService;
    @Autowired
    CustomerService customerService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
            customer = customerService.findById(customer.getCustomerId()).orElse(null);
        }
        request.setAttribute("customer", customer);
        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories", categories);
    }
}
