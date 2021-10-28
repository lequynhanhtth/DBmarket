package com.example.dbmarket.serviceImpl;

import com.example.dbmarket.entities.Product;
import com.example.dbmarket.entities.Shipper;
import com.example.dbmarket.repository.ProductRepository;
import com.example.dbmarket.repository.ShipperRepository;
import com.example.dbmarket.service.ProductService;
import com.example.dbmarket.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipperServiceImpl implements ShipperService {
    @Autowired
    ShipperRepository shipperRepository;

    @Override
    public List<Shipper> findAll() {
        return shipperRepository.findAll();
    }

    @Override
    public void save(Shipper shipper) {
        shipperRepository.save(shipper);
    }

    @Override
    public void delete(int id) {
        shipperRepository.deleteById(id);
    }

    @Override
    public Optional<Shipper> findById(int id) {
        return shipperRepository.findById(id);
    }

    @Override
    public boolean existById(int id) {
        return shipperRepository.existsById(id);
    }
}
