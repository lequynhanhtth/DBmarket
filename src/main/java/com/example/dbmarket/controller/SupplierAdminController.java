package com.example.dbmarket.controller;

import com.example.dbmarket.entities.Supplier;
import com.example.dbmarket.service.BannedService;
import com.example.dbmarket.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class SupplierAdminController {
    @Autowired
    SupplierService supplierService;
    @Autowired
    BannedService bannedService;


    @GetMapping("/admin/listSupllier")
    public String showListSupplier(Model model, Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        Page<Supplier> supplierPage = supplierService.findAll(pageable);
        model.addAttribute("supplierPage");
        return "views/content/admin/listSupplier";
    }

    @GetMapping("/admin/supplier/edit")
    public String showEditSupllier(int id, Model model) {
        Supplier supplier = supplierService.findById(id).orElse(null);
        model.addAttribute("supplier", supplier);
        return "views/content/admin/editSupplier";
    }
}
