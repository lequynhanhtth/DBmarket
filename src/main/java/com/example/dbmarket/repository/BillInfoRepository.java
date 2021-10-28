package com.example.dbmarket.repository;

import com.example.dbmarket.entities.BillInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillInfoRepository extends JpaRepository<BillInfo , Integer> {
}
