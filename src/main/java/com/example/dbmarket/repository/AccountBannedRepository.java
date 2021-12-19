package com.example.dbmarket.repository;

import com.example.dbmarket.entities.AccountBanned;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountBannedRepository extends JpaRepository<AccountBanned,Integer> {
    @Query(value="SELECT ab FROM AccountBanned ab WHERE ab.dateUnbanned = ''")
    public Page<AccountBanned> findAccountIsBanned(Pageable pageable);
}
