package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Category;
import com.example.dbmarket.entities.CategoryProduct;
import com.example.dbmarket.service.CategoryProductService;
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
public class CategoryProductController {
    @Autowired
    CategoryProductService categoryProductService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/admin/listCategoryProduct")
    public String showCategoryProduct(Model model, Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        Page<CategoryProduct> categoryProductPage = categoryProductService.findAll(pageable);
        model.addAttribute("categoryProductPage", categoryProductPage);
        return "views/content/admin/listcategoryproduct";
    }

    @GetMapping("/admin/addCategoryProduct")
    public String showAddCategoryProduct(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "views/content/admin/addcategoryproduct";
    }

    @PostMapping("/admin/addCategoryProduct")
    public String addCategoryProduct(CategoryProduct categoryProduct, int categoryId) {
        Category category = categoryService.findById(categoryId).orElse(null);
        categoryProduct.setCategory(category);
        categoryProductService.save(categoryProduct);
        return "redirect:/admin/listCategoryProduct";
    }
    @GetMapping("/admin/editCategoryProduct")
    public String showEditCategoryProduct(int id,Model model){
        CategoryProduct categoryProduct = categoryProductService.findById(id).orElse(null);
        model.addAttribute("categoryProduct",categoryProduct);
        return "views/content/admin/editcategoryproduct";
    }
    @PostMapping("/admin/editCategoryProduct")
    public String editCategoryProdut(CategoryProduct categoryProduct,int categoryId){
        Category category = categoryService.findById(categoryId).orElse(null);
        categoryProduct.setCategory(category);
        categoryProductService.save(categoryProduct);
        return"redirect:/admin/editCategoryProduct?id="+categoryProduct.getCategoryProductId();
    }
    @RequestMapping("/admin/categoryProduct/delete")
    public String deleteCategoryProduct(int id){
        categoryProductService.deleteById(id);
        return "redirect:/admin/listCategoryProduct";
    }
}
