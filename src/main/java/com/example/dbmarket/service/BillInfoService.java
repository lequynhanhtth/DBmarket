package com.example.dbmarket.service;

import com.example.dbmarket.entities.BillInfo;
import org.springframework.data.domain.Example;


import java.util.List;
import java.util.Optional;

public interface BillInfoService {
        BillInfo getById(Integer integer);

        List<BillInfo> findAll();

        void save(BillInfo billInfo);

        Optional<BillInfo> findById(Integer integer);

        boolean existsById(Integer integer);

        void deleteById(Integer integer);
}
