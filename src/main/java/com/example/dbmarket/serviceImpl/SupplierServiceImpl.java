package com.example.dbmarket.serviceImpl;

import com.example.dbmarket.entities.Shipper;
import com.example.dbmarket.entities.Supplier;
import com.example.dbmarket.repository.ShipperRepository;
import com.example.dbmarket.repository.SupplierRepository;
import com.example.dbmarket.service.ShipperService;
import com.example.dbmarket.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void delete(int id) {
        supplierRepository.deleteById(id);
    }

    @Override
    public Optional<Supplier> findById(int id) {
        return supplierRepository.findById(id);
    }

    @Override
    public boolean existById(int id) {
        return supplierRepository.existsById(id);
    }
}
