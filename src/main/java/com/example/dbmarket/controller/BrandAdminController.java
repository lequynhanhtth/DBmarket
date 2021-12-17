package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Brand;
import com.example.dbmarket.entities.Category;
import com.example.dbmarket.service.BrandService;
import com.example.dbmarket.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class BrandAdminController {
    @Autowired
    BrandService brandService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/admin/listBrand")
    public String showListBrand(Model model, Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        Page<Brand> brandPage = brandService.findAll(pageable);
        model.addAttribute("brandPage", brandPage);
        return "views/content/admin/listBrand";
    }

    @GetMapping("/admin/addBrand")
    public String showAddBrand( Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "views/content/admin/addBrand";
    }
    @PostMapping("/admin/addBrand")
    public String addBrand(String name, int categoryId){
        Brand brand = new Brand();
        brand.setBrandName(name);
        Category category = categoryService.findById(categoryId).orElse(null);
        brand.setCategory(category);
        brandService.save(brand);
        return "redirect:/admin/addBrand";
    }
    @GetMapping("/admin/editBrand")
    public String showEditBrand(int id,Model model){
        Brand brand = brandService.findById(id).orElse(null);
        model.addAttribute("brand",brand);
        return "views/content/admin/editBrand";
    }
    @PostMapping("/admin/editBrand")
    public String editBrand(Brand brand, int categoryId){
            Category category = categoryService.findById(categoryId).orElse(null);
            brand.setCategory(category);
            brandService.save(brand);
        return "redirect:/admin/editBrand?id="+brand.getBrandId();
    }
    @RequestMapping("/admin/brand/delete")
    public String deleteBrand(int id){
        brandService.deleteById(id);
        return "redirect:/admin/listBrand";
    }
}
