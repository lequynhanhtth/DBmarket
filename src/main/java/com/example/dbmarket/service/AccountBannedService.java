package com.example.dbmarket.service;

import com.example.dbmarket.entities.AccountBanned;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AccountBannedService {
    void save(AccountBanned accountBanned);

    void deleteById(int id);

    List<AccountBanned> findAll();

    Page<AccountBanned> findAll(Pageable pageable);

    Optional<AccountBanned> findById(int id);

    Page<AccountBanned> findAccountIsBanned(Pageable pageable);
}
