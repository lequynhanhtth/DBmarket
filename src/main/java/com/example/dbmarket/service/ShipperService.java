package com.example.dbmarket.service;

import com.example.dbmarket.entities.Shipper;

import java.util.List;
import java.util.Optional;

public interface ShipperService {
    public List<Shipper> findAll();

    public void save (Shipper shipper);

    public void delete(int id);

    public Optional<Shipper> findById(int id);

    public boolean existById(int id);
}
