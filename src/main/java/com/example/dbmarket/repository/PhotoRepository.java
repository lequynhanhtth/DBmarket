package com.example.dbmarket.repository;

import com.example.dbmarket.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo,Integer> {
}
