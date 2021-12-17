package com.example.dbmarket.serviceImpl;

import com.example.dbmarket.entities.Banned;
import com.example.dbmarket.repository.BannedRepository;
import com.example.dbmarket.service.BannedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BannedServiceImpl implements BannedService {
    @Autowired
    BannedRepository bannedRepository;
    @Override
    public void save(Banned banned) {
        bannedRepository.save(banned);
    }

    @Override
    public void deleteById(int id) {
        bannedRepository.deleteById(id);
    }

    @Override
    public List<Banned> findAll() {
        return bannedRepository.findAll();
    }

    @Override
    public Optional<Banned> findById(int id) {
        return bannedRepository.findById(id);
    }
}
