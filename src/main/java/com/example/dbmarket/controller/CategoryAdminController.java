package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Category;
import com.example.dbmarket.service.CategoryService;
import com.example.dbmarket.service.FileService;
import com.example.dbmarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Controller
public class CategoryAdminController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    FileService fileService;
    @Autowired
    ProductService productService;

    @GetMapping("/admin/listCategory")
    public String showListCategory(Optional<String> page, Model model) {
        Pageable pageable = PageRequest.of(Integer.parseInt(page.orElse("0")), 12);
        Page<Category> pageCategory = categoryService.findAdd(pageable);
        model.addAttribute("pageCategory", pageCategory);
        return "views/content/admin/listcategory";
    }

    @GetMapping("/admin/addCategory")
    public String showAddCategoryAdmin() {
        return "views/content/admin/addCategory";
    }

    @PostMapping("/admin/addCategory")
    public String addCategoryAdmin(String name, MultipartFile photo, MultipartFile photoSmall) {
        Category category = new Category();
        category.setName(name);
        categoryService.save(category);
        fileService.save(photo, "/src/main/resources/static/assets/images/category/" + category.getCategoryId());
        category.setPhoto(photo.getOriginalFilename());
        fileService.save(photoSmall, "/src/main/resources/static/assets/images/category/" + category.getCategoryId());
        category.setPhotoSmall(photoSmall.getOriginalFilename());
        categoryService.save(category);
        return "redirect:/admin/addCategory";
    }

    @GetMapping("/admin/editCategory")
    public String showEditCategory(int id, Model model) {
        Category category = categoryService.findById(id).orElse(null);
        model.addAttribute("category", category);
        return "views/content/admin/editCategory";
    }

    @PostMapping("/admin/editCategory")
    public String editCategory(Category category, MultipartFile photo1, MultipartFile photoSmall1) {
        Category categoryOld = categoryService.findById(category.getCategoryId()).orElse(null);
        if (photo1 != null && photo1.isEmpty() != true) {
            fileService.save(photo1, "/src/main/resources/static/assets/images/category/" + category.getCategoryId());
            category.setPhoto(photo1.getOriginalFilename());
        } else {
            category.setPhoto(categoryOld.getPhoto());
        }
        if (photoSmall1 != null && photoSmall1.isEmpty() != true) {
            fileService.save(photoSmall1, "/src/main/resources/static/assets/images/category/" + category.getCategoryId());
            category.setPhotoSmall(photoSmall1.getOriginalFilename());
        } else {
            category.setPhotoSmall(categoryOld.getPhotoSmall());
        }
        categoryService.save(category);
        return "redirect:/admin/editCategory?id=" + category.getCategoryId();
    }

    @RequestMapping("/admin/category/delete")
    public String deleteCategory(int id) {
        Category category = categoryService.findById(id).orElse(null);
        category.setStatus(false);
        categoryService.save(category);
        productService.changeStatusFalseProductByCategoryId(id);
        return "redirect:/admin/listCategory";
    }

    @RequestMapping("/admin/category/accept")
    public String acceptCategory(int id){
        Category category = categoryService.findById(id).orElse(null);
        category.setStatus(true);
        categoryService.save(category);
        productService.changeStatusTrueProductByCategoryId(id);
        return "redirect:/admin/listCategory";
    }

}
