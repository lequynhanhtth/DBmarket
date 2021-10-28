package com.example.dbmarket.serviceImpl;

import com.example.dbmarket.entities.BillInfo;
import com.example.dbmarket.entities.Customer;
import com.example.dbmarket.repository.BillInfoRepository;
import com.example.dbmarket.service.BillInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillInfoServiceImpl  implements BillInfoService {

    @Autowired
    BillInfoRepository billInfoRepository;

    public BillInfoServiceImpl(BillInfoRepository billInfoRepository) {
        this.billInfoRepository = billInfoRepository;
    }

    @Override
    public BillInfo getById(Integer integer) {
        return billInfoRepository.getById(integer);
    }

    @Override
    public List<BillInfo> findAll() {
        return billInfoRepository.findAll();
    }

    @Override
    public void save(BillInfo billInfo) {
        billInfoRepository.save(billInfo);
    }

    @Override
    public Optional<BillInfo> findById(Integer integer) {
        return billInfoRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return billInfoRepository.existsById(integer);
    }

    @Override
    public void deleteById(Integer integer) {
        billInfoRepository.deleteById(integer);
    }
}
