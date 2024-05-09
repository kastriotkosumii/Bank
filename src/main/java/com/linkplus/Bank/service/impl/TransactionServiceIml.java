package com.linkplus.Bank.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.linkplus.Bank.Exception.ResourceNotFoundException;
import com.linkplus.Bank.model.Account;
import com.linkplus.Bank.model.Transaction;
import com.linkplus.Bank.model.enums.FeeType;
import com.linkplus.Bank.payload.request.Transaction.FundTransferRequest;
import com.linkplus.Bank.repository.AccountRepository;
import com.linkplus.Bank.repository.TransactionRepository;
import com.linkplus.Bank.service.TransactionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionServiceIml implements TransactionService{

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Value("${transaction.chargeFeePercentage}")
    private double chargeFeePercentage;

    @Override
    public void fundTransfer(FundTransferRequest fundTransfer) {
        Account fromAccount = accountRepository.findById(fundTransfer.fromAccount())
                            .orElseThrow(() -> new ResourceNotFoundException("Account not found!"));

        Account toAccount = accountRepository.findById(fundTransfer.toAccount())
                            .orElseThrow(() -> new ResourceNotFoundException("Account not found!"));

        if(fundTransfer.ammount() <= 0)
            throw new RuntimeException("Fund transfer most be grater than 0");
        
        Double calculatedFee = calculateFee(fundTransfer.ammount(), fundTransfer.feeType()); 

        toAccount.setAccountBalance(toAccount.getAccountBalance() - calculatedFee);
        fromAccount.setAccountBalance(fromAccount.getAccountBalance() - fundTransfer.ammount());

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        Transaction transaction = new Transaction();

        transaction.setAmmount(fundTransfer.ammount());
        transaction.setFromAccount(fromAccount);
        transaction.setToAccount(toAccount);
        transaction.setReason(fundTransfer.reason());
        transaction.setFeeType(FeeType.valueOf(fundTransfer.feeType()));
        transaction.setFeeCharged(calculatedFee);

        transactionRepository.save(transaction);

    }

    private Double calculateFee(Double ammount, String feeType) {
        if(feeType.trim().equals(FeeType.FLAT_FEE.toString()))
            return 10.00;

        return ammount * (chargeFeePercentage/100);

    }
    
}
