package com.linkplus.Bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linkplus.Bank.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {

}
