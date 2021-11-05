package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Cart;
import com.example.dbmarket.entities.CartDetail;
import com.example.dbmarket.entities.Customer;
import com.example.dbmarket.service.CartDetailService;
import com.example.dbmarket.service.CartService;
import com.example.dbmarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

public class CartController {
    @Autowired
    HttpSession session;
    @Autowired
    CartService cartService;
    @Autowired
    CartDetailService cartDetailService;
    @Autowired
    ProductService productService;

    @RequestMapping("/user/cart")
    public String showCart(Model model){
        Customer customer = new Customer();
        List<Cart> carts = customer.getCart();
        if(carts != null){
            Cart  cart = carts.get(0);

            List<CartDetail> cartDetails = cart.getCartDetails();

            model.addAttribute("cartDetails" , cartDetails);

            model.addAttribute("cart" , cart);
        }

        return "/views/content/cart";
    }





    @RequestMapping("user/cart/{id}")
    public String addCart(int id){


        Customer customer =(Customer)session.getAttribute("customer");
        Cart cart = customer.getCart().get(customer.getCart().size()-1);
        CartDetail cartDetail = cartDetailService.findByProductId(id, cart.getCartId()).orElse(null);
        if(cartDetail == null) {
            cartDetail = new CartDetail();
            cartDetail.setCart(cart);
            cartDetail.setQuantity(1);
            cartDetail.setProduct(productService.findById(id).orElse(null));
            cartDetailService.save(cartDetail);
        }else{
            cartDetail.setQuantity(cartDetail.getQuantity()+1);
        }
        cartDetailService.save(cartDetail);
        return "";
    }
}
