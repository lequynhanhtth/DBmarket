package com.example.dbmarket.controller;

import com.example.dbmarket.entities.*;
import com.example.dbmarket.service.CartDetailService;
import com.example.dbmarket.service.CustomerService;
import com.example.dbmarket.service.OrderDetailService;
import com.example.dbmarket.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CheckoutController {

    @Autowired
    HttpSession session;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CartDetailService cartDetailService;

    @GetMapping("/customer/cart/order")
    public String showOrder(Model model) {
        Customer customer = (Customer) session.getAttribute("customer");
        customer = customerService.findById(customer.getCustomerId()).orElse(null);
        List<Cart> carts = customer.getCart();
        if (carts != null) {
            Cart cart = carts.get(carts.size() - 1);
            List<CartDetail> cartDetails = cart.getCartDetails();
            model.addAttribute("cartDetails", cartDetails);
            model.addAttribute("cart", cart);
        }
        return "views/content/checkout";
    }
    @PostMapping("/customer/cart/order" )
    public String placeOrder(Model model, Order order) {
        Customer customer = (Customer) session.getAttribute("customer");
        customer = customerService.findById(customer.getCustomerId()).orElse(null);
        List<Cart> carts = customer.getCart();
        Cart cart = carts.get(carts.size() - 1);
        List<CartDetail> cartDetails = cart.getCartDetails();

        Map<Integer, Order> orders = new HashMap<>();
        for (CartDetail x : cartDetails) {
            if (orders.get(x.getProduct().getSupplier().getSupplierId()) == null) {
                Order ordernew = order;
                ordernew.setDate(LocalDate.now());
                ordernew.setStatus("Wait Confirm");
                ordernew.setTimeOrder(LocalTime.now());
                ordernew.setSupplier(x.product.getSupplier());
                ordernew.setShipCost(x.getProduct().getPrice() * x.getQuantity());
                ordernew.setCustomer(customer);
                orders.put(x.getProduct().getSupplier().getSupplierId(), ordernew);
            } else {
                Order orderOld = orders.get(x.getProduct().getSupplier().getSupplierId());
                orderOld.setShipCost(orderOld.getShipCost() + x.getProduct().getPrice() * x.getQuantity());
                orders.put(x.getProduct().getSupplier().getSupplierId(), orderOld);
            }
        }
        for (Integer x : orders.keySet()) {
            orderService.save(orders.get(x));
            for (CartDetail cartDetail : cartDetails) {
                if (cartDetail.getProduct().getSupplier().getSupplierId() == x) {
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setOrder(orders.get(x));
                    orderDetail.setProduct(cartDetail.getProduct());
                    orderDetail.setQuantity(cartDetail.getQuantity());
                    orderDetail.setTotalPrice(cartDetail.getProduct().getPrice() * cartDetail.getQuantity());
                        orderDetailService.save(orderDetail);
                }
            }
        }
        return "views/content/success";
    }
}
