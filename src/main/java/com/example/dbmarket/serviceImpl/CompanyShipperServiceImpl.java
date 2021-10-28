package com.example.dbmarket.serviceImpl;

import com.example.dbmarket.entities.CompanyShipper;
import com.example.dbmarket.repository.CompanyShipperRepository;
import com.example.dbmarket.service.CompanyShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyShipperServiceImpl implements CompanyShipperService {
    @Autowired
    CompanyShipperRepository companyShipperRepository;

    @Override
    public List<CompanyShipper> findAll() {
        return companyShipperRepository.findAll();

    }

    @Override
    public void save(CompanyShipper companyShipper) {
        companyShipperRepository.save(companyShipper);
    }

    @Override
    public void delete(int id) {
        companyShipperRepository.deleteById(id);

    }

    @Override
    public Optional<CompanyShipper> findById(int id) {
        return companyShipperRepository.findById(id);
    }

    @Override
    public boolean existById(int id) {
        return companyShipperRepository.existsById(id);
    }
}
