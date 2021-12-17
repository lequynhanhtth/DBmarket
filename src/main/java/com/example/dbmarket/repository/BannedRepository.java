package com.example.dbmarket.repository;

import com.example.dbmarket.entities.Banned;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannedRepository extends JpaRepository<Banned,Integer> {
}
