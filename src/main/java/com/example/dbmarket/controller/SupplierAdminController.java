package com.example.dbmarket.controller;

import com.example.dbmarket.entities.AccountBanned;
import com.example.dbmarket.entities.Banned;
import com.example.dbmarket.entities.Supplier;
import com.example.dbmarket.service.AccountBannedService;
import com.example.dbmarket.service.BannedService;
import com.example.dbmarket.service.ProductService;
import com.example.dbmarket.service.SupplierService;
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
public class SupplierAdminController {
    @Autowired
    SupplierService supplierService;
    @Autowired
    BannedService bannedService;
    @Autowired
    AccountBannedService accountBannedService;
    @Autowired
    ProductService productService;

    @GetMapping("/admin/listSupplier")
    public String showSupplier(Model model, Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        Page<Supplier> supplierPage = supplierService.findAll(pageable);
        model.addAttribute("supplierPage", supplierPage);
        return "views/content/admin/listSupplier";
    }

    @GetMapping("/admin/editSupplier")
    public String showEditSupplier(int id, Model model) {
        Supplier supplier = supplierService.findById(id).orElse(null);
        List<Banned> banneds = bannedService.findAll();
        model.addAttribute("supplier", supplier);
        model.addAttribute("banneds", banneds);
        return "views/content/admin/editSupplier";
    }

    @PostMapping("/admin/editSupplier")
    public String EditCustomer(int supplierId, Optional<Integer> bannedId, String description) {
        Supplier supplier = supplierService.findById(supplierId).orElse(null);
        Banned banned = bannedService.findById(bannedId.orElse(-1)).orElse(null);
        AccountBanned accountBanned = new AccountBanned();
        accountBanned.setBanned(banned);
        accountBanned.setSupplier(supplier);
        accountBanned.setDateBanned(LocalDate.now());
        accountBanned.setDescription(description);
        productService.changeStatusFalseProductBySupplier(supplierId);
        accountBannedService.save(accountBanned);
        return "redirect:/admin/editSupplier?id=" + supplierId;
    }

    @RequestMapping("/admin/supplier/unBanned")
    public String Unbanned(int id) {
        Supplier supplier = supplierService.findById(id).orElse(null);
        AccountBanned accountBanned = supplier.getAccountBanneds().get(supplier.getAccountBanneds().size() - 1);
        accountBanned.setDateUnbanned(LocalDate.now());
        productService.changeStatusTrueProductBySupplier(id);
        accountBannedService.save(accountBanned);

        return "redirect:/admin/editSupplier?id=" + id;
    }

    @RequestMapping("/admin/supplier/listBanned")
    public String showListBanned(Model model, Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        Page<AccountBanned> accountBanneds = accountBannedService.findAccountIsBanned(pageable);
        model.addAttribute("accountBanneds", accountBanneds);

        return "views/content/admin/listBanned";
    }
}