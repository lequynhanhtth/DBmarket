package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Cart;
import com.example.dbmarket.entities.CartDetail;
import com.example.dbmarket.entities.Customer;
import com.example.dbmarket.service.CartDetailService;
import com.example.dbmarket.service.CartService;
import com.example.dbmarket.service.CustomerService;
import com.example.dbmarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    CustomerService customerService;

    @RequestMapping("customer/showCart")
    public String showCart(Model model) {
        Customer customer = (Customer) session.getAttribute("customer");
        customer = customerService.findById(customer.getCustomerId()).orElse(null);
        List<Cart> carts = customer.getCart();
        if (carts != null) {
            Cart cart = carts.get(0);

            List<CartDetail> cartDetails = cart.getCartDetails();

            model.addAttribute("cartDetails", cartDetails);

            model.addAttribute("cart", cart);
        }

        return "/views/content/cart";
    }

    @RequestMapping("customer/cart")
    public String addCart(int id, String url, Integer quantity) {
        Customer customer = (Customer) session.getAttribute("customer");
        customer = customerService.findById(customer.getCustomerId()).orElse(null);
        Cart cart = new Cart();
        if (customer.getCart().size() == 0) {
            cart.setCustomer(customer);
            cart.setTotalPrice(0.0);
            cart.setNumberOfProduct(0);
            cartService.save(cart);
        } else {
            cart = customer.getCart().get(customer.getCart().size() - 1);
        }
        CartDetail cartDetail = cartDetailService.findByProductId(id, cart.getCartId()).orElse(null);
        if (cartDetail == null) {
            cartDetail = new CartDetail();
            cartDetail.setCart(cart);
            if (quantity != null) {
                cartDetail.setQuantity(quantity);
            } else {
                cartDetail.setQuantity(1);
            }
            cartDetail.setProduct(productService.findById(id).orElse(null));
            cartDetailService.save(cartDetail);
        } else {
            if (quantity != null) {
                cartDetail.setQuantity(cartDetail.getQuantity() + quantity);
            } else {
                cartDetail.setQuantity(cartDetail.getQuantity() + 1);
            }
            cartDetailService.save(cartDetail);
        }
        cart.setTotalPrice((double) (cart.getTotalPrice() + cartDetail.getQuantity() * cartDetail.getProduct().getPrice()));
        cart.setNumberOfProduct(cart.getNumberOfProduct() + cartDetail.getQuantity());
        cartService.save(cart);
        return "redirect:" + url;
    }

    @GetMapping("customer/cart/edit")
    public String editCart(int id, String urlEdit, int quantity) {
        Customer customer = (Customer) session.getAttribute("customer");
        customer = customerService.findById(customer.getCustomerId()).orElse(null);
        Cart cart = new Cart();
        if (customer.getCart().size() == 0) {
            cart.setCustomer(customer);
            cart.setTotalPrice(0.0);
            cart.setNumberOfProduct(0);
            cartService.save(cart);
        } else {
            cart = customer.getCart().get(customer.getCart().size() - 1);
        }
        if (urlEdit.indexOf(",") >= 0) {
            urlEdit = urlEdit.split(",")[0];
        }
        CartDetail cartDetail = cartDetailService.findByProductId(id, cart.getCartId()).orElse(null);
        cartDetail.setQuantity(quantity);
        cartDetailService.save(cartDetail);
        return "redirect:" + urlEdit;
    }

    @RequestMapping("customer/cart/delete")
    public String deleteCart(int id, String url) {
        cartDetailService.delete(id);
        return "redirect:" + url;
    }
}
