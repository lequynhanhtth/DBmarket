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
import java.util.ArrayList;
import java.util.List;

@Controller
public class EditProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    FileService fileService;
    @Autowired
    PhotoService photoService;
    @Autowired
    CategoryProductService categoryProductService;
    @Autowired
    BrandService brandService;
    @Autowired
    HttpSession session;

    @GetMapping("supplier/product/edit")
    public String showProductEdit(Model model, int id) {

        Product product = productService.findById(id).orElse(null);
        List<CategoryProduct> categoryProducts = product.getCategory().getCategoryProducts();
        List<Brand> brands = product.getCategory().getBrands();
        List<Category> categories = categoryService.findAll();
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        model.addAttribute("brands", brands);
        model.addAttribute("categoryProducts", categoryProducts);
        return "views/content/supplier/editProduct";
    }

    @PostMapping("supplier/product/edit")
    public String editProductEdit(Product product, List<MultipartFile> photo1, int categoryId, int brandId, int categoryProductId) {
        Category category = categoryService.findById(categoryId).orElse(null);
        Supplier supplier = (Supplier) session.getAttribute("supplier");
        CategoryProduct categoryProduct = categoryProductService.findById(categoryProductId).orElse(null);
        Brand brand = brandService.findById(brandId).orElse(null);
        product.setDate(LocalDate.now());
        Photo photo;
        List<Photo> photos = photoService.findByProductId(product.getProductId());
        product.setCategoryProduct(categoryProduct);
        product.setBrand(brand);
        product.setPhotos(photos);
        product.setSupplier(supplier);
        product.setCategory(category);
        productService.save(product);
        int index = 0;
        for (MultipartFile x : photo1) {
            photo = photos.get(index++);
            if (!x.isEmpty()) {
                fileService.save(x, "/src/main/resources/static/assets/images/product/" + product.getProductId());
                photo.setPhotoName(x.getOriginalFilename());
            }
            photo.setProduct(product);
            photoService.save(photo);
        }

        return "redirect:/supplier/product/edit?id=" + product.getProductId();
    }

    @GetMapping("supplier/product/edit/chooseCategory")
    public String showEditCategory(Model model, int id) {
        Product product = productService.findById(id).orElse(null);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        return "views/content/supplier/chooseCategoryEdit";
    }

    @PostMapping("supplier/product/edit/chooseCategory")
    public String editCategory(int categoryId, int productId) {
        Product product = productService.findById(productId).orElse(null);
        Category category = categoryService.findById(categoryId).orElse(null);
        product.setCategory(category);
        productService.save(product);
        return "redirect:/supplier/product/edit?id=" + product.getProductId();
    }
}
