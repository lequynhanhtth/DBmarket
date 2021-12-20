package com.example.dbmarket.controller;

import com.example.dbmarket.entities.*;
import com.example.dbmarket.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
public class AddProductController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    PhotoService photoService;
    @Autowired
    FileService fileService;
    @Autowired
    BrandService brandService;
    @Autowired
    CategoryProductService categoryProductService;
    @Autowired
    HttpSession session;

    @GetMapping("supplier/chooseCategory")
    public String showChooseCategory(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "views/content/supplier/choosecategory";
    }

    @PostMapping("supplier/chooseCategory")
    public String chooseCategory(int categoryId) {
        return "redirect:/supplier/addProduct?categoryId=" + categoryId;
    }

    @GetMapping("supplier/addProduct")
    public String showAddProduct(Model model, int categoryId) {
        Category category = categoryService.findById(categoryId).orElse(null);
        List<Brand> brands = category.getBrands();
        List<CategoryProduct> categoryProducts = category.getCategoryProducts();
        model.addAttribute("brands", brands);
        model.addAttribute("categoryProducts", categoryProducts);
        model.addAttribute("categoryId", categoryId);
        return "views/content/supplier/addproduct";
    }

    @PostMapping("supplier/addProduct")
    public String addProduct(Product product, List<MultipartFile> photo1, int brandId, int categoryProductId) {
        Supplier supplier = (Supplier) session.getAttribute("supplier");
        CategoryProduct categoryProduct = categoryProductService.findById(categoryProductId).orElse(null);
        Brand brand = brandService.findById(brandId).orElse(null);
        Photo photo;
        product.setDate(LocalDate.now());
        product.setSupplier(supplier);
        product.setCategoryProduct(categoryProduct);
        product.setBrand(brand);
        product.setAccept(false);
        product.setStatus(true);
        product.setDiscount(0.0);
        productService.save(product);
        for (MultipartFile x : photo1) {
            photo = new Photo();
            if (!x.isEmpty()) {
                fileService.save(x, "/src/main/resources/static/assets/images/product/" + product.getProductId());
                photo.setPhotoName(x.getOriginalFilename());
            }
            photo.setProduct(product);
            photoService.save(photo);
        }
        return "redirect:/supplier/chooseCategory";
    }
}
