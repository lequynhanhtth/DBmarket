package com.example.dbmarket.serviceImpl;

import com.example.dbmarket.entities.AccountBanned;
import com.example.dbmarket.repository.AccountBannedRepository;
import com.example.dbmarket.service.AccountBannedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountBannedServiceImpl implements AccountBannedService {
    @Autowired
    AccountBannedRepository accountBannedRepository;
    @Override
    public void save(AccountBanned accountBanned) {
        accountBannedRepository.save(accountBanned);
    }

    @Override
    public void deleteById(int id) {
            accountBannedRepository.deleteById(id);
    }

    @Override
    public List<AccountBanned> findAll() {
        return accountBannedRepository.findAll();
    }

    @Override
    public Page<AccountBanned> findAll(Pageable pageable) {
        return accountBannedRepository.findAll(pageable);
    }

    @Override
    public Optional<AccountBanned> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Page<AccountBanned> findAccountIsBanned(Pageable pageable) {
        return accountBannedRepository.findAccountIsBanned(pageable);
    }
}
