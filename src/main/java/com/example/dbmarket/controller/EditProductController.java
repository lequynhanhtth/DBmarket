package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Category;
import com.example.dbmarket.entities.Photo;
import com.example.dbmarket.entities.Product;
import com.example.dbmarket.entities.Supplier;
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
    HttpSession session;
    @GetMapping("supplier/product/edit")
    public String showProductEdit(Model model, int id) {
        Product product = productService.findById(id).orElse(null);
        List<Category> categories =  categoryService.findAll();
        model.addAttribute("product",product);
        model.addAttribute("categories",categories);
        return "views/content/supplier/editProduct";
    }
    @PostMapping("supplier/product/edit")
    public String editProductEdit(Product product,List<MultipartFile> photo1){
        Supplier supplier = (Supplier) session.getAttribute("supplier");
        product.setDate(LocalDate.now());
        Photo photo  ;
        List<Photo> photos = photoService.findByProductId(product.getProductId());
        product.setPhotos(photos);
        product.setSupplier(supplier);
        productService.save(product);
        int index = 0;
        for(MultipartFile x : photo1){
            photo = photos.get(index++);
            if(!x.isEmpty()) {
                fileService.save(x, "/src/main/resources/static/assets/images/product/" + product.getProductId());
                photo.setPhotoName(x.getOriginalFilename());
            }
            photo.setProduct(product);
            photoService.save(photo);
        }

     return "redirect:/supplier/product/edit?id="+product.getProductId();
    }
}
