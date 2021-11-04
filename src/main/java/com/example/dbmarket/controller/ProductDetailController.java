package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Product;
import com.example.dbmarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/DBmarket")
public class ProductDetailController {
    @Autowired
    ProductService productService;
    @Autowired
    HttpSession session;

    @GetMapping("/productdetail/{id}")
    public String getProductDetail(@PathVariable("id") int id, Model model){
        Product product = productService.findById(id).get();
        model.addAttribute("productDetail", product);
        Pageable pageable = PageRequest.of(0, 4);
        List<Product> products = productService.findByCategoryOrderByRate(product.getCategory().getCategoryId(), pageable).getContent();
        model.addAttribute("productdetails", products);
        session.setAttribute("uriProductDetail","/views/productdetail/"+id);
        return "views/content/productdetail";
    }

    @GetMapping("productdetail")
    public String showProductDetail(){
        return "views/content/productdetail";
    }

//    @GetMapping("/user/cart/add")
//    public String addCart(@RequestParam("id") long id, @RequestParam("soluong") int quantity, @RequestParam("size") String size) {
//        Product product = productService.findById(id).get();
//        CartDAO.addCart(id,quantity,product,size);
//        return "redirect:/home/productdetail/" + id;
//    }
}
