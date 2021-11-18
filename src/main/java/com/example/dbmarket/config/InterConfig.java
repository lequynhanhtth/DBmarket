package com.example.dbmarket.config;

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
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(global).addPathPatterns("/**").excludePathPatterns("/assets/**");
        registry.addInterceptor(supplier).addPathPatterns("/supplier/**").excludePathPatterns("/assets/**");
    }
}
