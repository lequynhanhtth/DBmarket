package com.example.dbmarket.Interceptor;

import com.example.dbmarket.entities.Admin;
import com.example.dbmarket.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Autowired
    HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            response.sendRedirect("/showLoginAdmin");
            return false;
        } else {
            request.setAttribute("admin", admin);
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}
