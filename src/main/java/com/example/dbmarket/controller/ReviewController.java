package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Rate;
import com.example.dbmarket.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class ReviewController {
    @Autowired
    RateService rateService;

    @GetMapping("/productDetail/review")
    public String showReview(Model model, Optional<Integer> page, int productId) {
        Pageable pageable = PageRequest.of(page.orElse(0), 6);
        Page<Rate> ratePage = rateService.findRateByProductId(productId, pageable);
        model.addAttribute("ratePage", ratePage);
        return "views/content/review";
    }
}
