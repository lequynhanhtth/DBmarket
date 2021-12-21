package com.example.dbmarket.config;

import com.example.dbmarket.Interceptor.AdminInterceptor;
import com.example.dbmarket.Interceptor.CustomerInterceptor;
import com.example.dbmarket.Interceptor.GlobalInterceptor;
import com.example.dbmarket.Interceptor.SupplierInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterConfig implements WebMvcConfigurer {
    @Autowired
    GlobalInterceptor global;
    @Autowired
    SupplierInterceptor supplier;
    @Autowired
    CustomerInterceptor customer;
    @Autowired
    AdminInterceptor admin;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(global).addPathPatterns("/**").excludePathPatterns("/assets/**");
        registry.addInterceptor(supplier).addPathPatterns("/supplier/**","/suplier/**").excludePathPatterns("/assets/**");
        registry.addInterceptor(customer).addPathPatterns("/customer/**").excludePathPatterns("/assets/**");
        registry.addInterceptor(admin).addPathPatterns("/admin/**","/admin/**/**/**","/admin/**/**").excludePathPatterns("/assets/**");
    }
}
