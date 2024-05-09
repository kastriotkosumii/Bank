package com.linkplus.Bank.service.impl;

import org.springframework.stereotype.Service;

import com.linkplus.Bank.Exception.ResourceNotFoundException;
import com.linkplus.Bank.model.Account;
import com.linkplus.Bank.model.Transaction;
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

    @Override
    public void fundTransfer(FundTransferRequest fundTransfer) {
        Account fromAccount = accountRepository.findById(fundTransfer.fromAccount())
                            .orElseThrow(() -> new ResourceNotFoundException("Account not found!"));

        Account toAccount = accountRepository.findById(fundTransfer.toAccount())
                            .orElseThrow(() -> new ResourceNotFoundException("Account not found!"));

        if(fundTransfer.ammount() <= 0)
            throw new RuntimeException("Fund transfer most be grater than 0");
        
        toAccount.setAccountBalance(toAccount.getAccountBalance() + fundTransfer.ammount());
        fromAccount.setAccountBalance(fromAccount.getAccountBalance() - fundTransfer.ammount());

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        Transaction transaction = new Transaction();

        transaction.setAmmount(fundTransfer.ammount());
        transaction.setFromAccount(fromAccount);
        transaction.setToAccount(toAccount);
        transaction.setReason(fundTransfer.reason());

        transactionRepository.save(transaction);

    }
    
}
