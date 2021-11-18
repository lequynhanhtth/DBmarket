package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Category;
import com.example.dbmarket.entities.Photo;
import com.example.dbmarket.entities.Product;
import com.example.dbmarket.entities.Supplier;
import com.example.dbmarket.service.CategoryService;
import com.example.dbmarket.service.FileService;
import com.example.dbmarket.service.PhotoService;
import com.example.dbmarket.service.ProductService;
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
    HttpSession session;
    @GetMapping("supplier/addProduct")
    public String showAddProduct(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "views/content/supplier/addproduct";
    }
    @PostMapping("supplier/addProduct")
    public String addProduct(Product product, List<MultipartFile> photo1){
        Supplier supplier = (Supplier) session.getAttribute("supplier");
        Photo photo ;
        product.setDate(LocalDate.now());
        product.setSupplier(supplier);
        productService.save(product);
       for(MultipartFile x : photo1){
           photo = new Photo();
        if(!x.isEmpty()) {
            fileService.save(x, "/src/main/resources/static/assets/images/product/" + product.getProductId());
            photo.setPhotoName(x.getOriginalFilename());
        }
        photo.setProduct(product);
        photoService.save(photo);
       }
        return "redirect:/supplier/addProduct";
    }
}
