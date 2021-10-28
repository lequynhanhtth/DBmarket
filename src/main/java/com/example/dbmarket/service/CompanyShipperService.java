package com.example.dbmarket.service;

import com.example.dbmarket.entities.Category;
import com.example.dbmarket.entities.CompanyShipper;

import java.util.List;
import java.util.Optional;

public interface CompanyShipperService {
    public List<CompanyShipper> findAll();

    public void save (CompanyShipper companyShipper);

    public void delete(int id);

    public Optional<CompanyShipper> findById(int id);

    public boolean existById(int id);
}
