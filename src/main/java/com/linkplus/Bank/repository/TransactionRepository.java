package com.linkplus.Bank.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.linkplus.Bank.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    
    @Query()
    double getTransactionFeeAmount();
}
