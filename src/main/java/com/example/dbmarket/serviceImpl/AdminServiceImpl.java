package com.example.dbmarket.serviceImpl;

import com.example.dbmarket.entities.Admin;
import com.example.dbmarket.repository.AdminRepository;
import com.example.dbmarket.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public void save(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void deleteById(int id) {
        adminRepository.deleteById(id);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> findById(int id) {
        return adminRepository.findById(id);
    }

    @Override
    public Optional<Admin> findByAdmin(String email) {
        return adminRepository.findByEmail(email);
    }

    @Override
    public Page<Admin> findAll(Pageable pageable) {
        return adminRepository.findAll(pageable);
    }
}
