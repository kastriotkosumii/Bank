package com.linkplus.Bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linkplus.Bank.model.BankUser;

public interface BankUserRepository extends JpaRepository<BankUser, Long> {

}
