package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Brand;
import com.example.dbmarket.entities.Category;
import com.example.dbmarket.entities.CategoryProduct;
import com.example.dbmarket.entities.Product;
import com.example.dbmarket.repository.ProductRepository;
import com.example.dbmarket.service.BrandService;
import com.example.dbmarket.service.CategoryProductService;
import com.example.dbmarket.service.CategoryService;
import com.example.dbmarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/DBmarket")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    BrandService brandService;
    @Autowired
    CategoryProductService categoryProductService;

    @GetMapping("/Category")
    public String showCategory(int categoryId, Optional<Integer> page, Model model) {
        Pageable pageable = PageRequest.of(page.orElse(0), 12);
        Category category = categoryService.findById(categoryId).orElse(null);
        //    Page<Product> productPage = productService.findManyOption(brands.orElse(null),categoryProducts.orElse(null),minPrice.orElse(0.0),maxPrice.orElse(10000000.0),categoryId,pageable);
        Page<Product> productPage = productService.findByCategoryId(categoryId, pageable);
        List<CategoryProduct> categoryProductList = category.getCategoryProducts();
        List<Brand> brandList = category.getBrands();
        model.addAttribute("productPage", productPage);
        model.addAttribute("brands", brandList);
        model.addAttribute("categoryProducts", categoryProductList);
        model.addAttribute("categoryId", categoryId);
        return "views/content/category";
    }

    @GetMapping("/Category/filter")
    public String filterData(int categoryId, int[] categoryProducts, int[] brands, Optional<Long> minPrice, Optional<Long> maxPrice, Optional<Integer> page, Model model, Optional<String> search) {
        Pageable pageable = PageRequest.of(page.orElse(0), 12);
        Category category = categoryService.findById(categoryId).orElse(null);
        List<CategoryProduct> categoryProductList = category.getCategoryProducts();
        List<Brand> brandList = category.getBrands();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        if (categoryProducts == null) {
            for (CategoryProduct categoryProduct : categoryProductList) {
                c.add(categoryProduct.getCategoryProductId());
            }
            model.addAttribute("categoryProductNull", false);
        } else {
            for (int categoryProduct : categoryProducts) {
                c.add(categoryProduct);
            }
            model.addAttribute("categoryProductNull", true);
        }
        if (brands == null) {
            for (Brand brand : brandList) {
                b.add(brand.getBrandId());

            }
            model.addAttribute("brandNull", false);
        } else {
            for (int brand : brands) {
                b.add(brand);
            }
            model.addAttribute("brandNull", true);

        }
        Page<Product> productPage = productService.findManyOption(b, c, minPrice.orElse((long) 0), maxPrice.orElse((long) 10000000), categoryId, pageable, "%" + search.orElse("") + "%");
        model.addAttribute("productPage", productPage);
        model.addAttribute("brands", brandList);
        model.addAttribute("categoryProducts", categoryProductList);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("categoryProductsArray", c);
        model.addAttribute("brandsArray", b);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("search");
        return "views/content/category";
    }

}
