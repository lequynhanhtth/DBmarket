package com.example.dbmarket.service;

import com.example.dbmarket.entities.Banned;

import java.util.List;
import java.util.Optional;

public interface BannedService {
    void save(Banned banned);

    void deleteById(int id);

    List<Banned> findAll();

    Optional<Banned> findById(int id);
}
