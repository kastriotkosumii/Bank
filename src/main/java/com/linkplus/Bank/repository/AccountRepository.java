package com.linkplus.Bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linkplus.Bank.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    
}
