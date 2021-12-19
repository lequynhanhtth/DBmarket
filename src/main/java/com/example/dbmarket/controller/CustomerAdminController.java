package com.example.dbmarket.controller;

import com.example.dbmarket.entities.AccountBanned;
import com.example.dbmarket.entities.Banned;
import com.example.dbmarket.entities.Customer;
import com.example.dbmarket.service.AccountBannedService;
import com.example.dbmarket.service.BannedService;
import com.example.dbmarket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerAdminController {
    @Autowired
    CustomerService customerService;
    @Autowired
    BannedService bannedService;
    @Autowired
    AccountBannedService accountBannedService;

    @GetMapping("/admin/listCustomer")
    public String showCustomer(Model model, Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        Page<Customer> customerPage = customerService.findAll(pageable);
        model.addAttribute("customerPage", customerPage);
        return "views/content/admin/listCustomer";
    }

    @GetMapping("/admin/editCustomer")
    public String showEditCustomer(int id, Model model) {
        Customer customer = customerService.findById(id).orElse(null);
        List<Banned> banneds = bannedService.findAll();
        model.addAttribute("customer", customer);
        model.addAttribute("banneds", banneds);
        return "views/content/admin/editCustomer";
    }

    @PostMapping("/admin/editCustomer")
    public String EditCustomer(int customerId, Optional<Integer> bannedId, String description) {
        Customer customer = customerService.findById(customerId).orElse(null);
        Banned banned = bannedService.findById(bannedId.orElse(-1)).orElse(null);
        AccountBanned accountBanned = new AccountBanned();
        accountBanned.setBanned(banned);
        accountBanned.setCustomer(customer);
        accountBanned.setDateBanned(LocalDate.now());
        accountBanned.setDescription(description);
        accountBannedService.save(accountBanned);
        return "redirect:/admin/editCustomer?id=" + customerId;
    }

    @RequestMapping("/admin/customer/unBanned")
    public String Unbanned(int id) {
        Customer customer = customerService.findById(id).orElse(null);
        AccountBanned accountBanned = customer.getAccountBanneds().get(customer.getAccountBanneds().size() - 1);
        accountBanned.setDateUnbanned(LocalDate.now());
        accountBannedService.save(accountBanned);
        return "redirect:/admin/editCustomer?id=" + id;
    }

    @RequestMapping("/admin/customer/listBanned")
    public String showListBanned(Model model, Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        Page<AccountBanned> accountBanneds = accountBannedService.findAccountIsBanned(pageable);
        model.addAttribute("accountBanneds",accountBanneds);
        return "views/content/admin/listBanned";
    }
}
