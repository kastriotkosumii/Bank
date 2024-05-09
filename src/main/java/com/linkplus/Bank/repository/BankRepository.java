package com.linkplus.Bank.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.linkplus.Bank.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {
    
    @Query(value = "SELECT SUM(t.feeCharged) FROM Transaction t")
    Double getTotalCharchedFee();
}
