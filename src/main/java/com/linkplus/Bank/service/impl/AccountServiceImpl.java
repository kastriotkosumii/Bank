package com.linkplus.Bank.service.impl;

import org.springframework.stereotype.Service;

import com.linkplus.Bank.Exception.ResourceNotFoundException;
import com.linkplus.Bank.model.Account;
import com.linkplus.Bank.model.BankUser;
import com.linkplus.Bank.payload.request.Account.AccountRegistrationRequest;
import com.linkplus.Bank.repository.AccountRepository;
import com.linkplus.Bank.repository.BankUserRepository;
import com.linkplus.Bank.service.AccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final BankUserRepository bankUserRepository;

    @Override
    public void addAccount(AccountRegistrationRequest accountRegistrationRequest) {
        BankUser bankUser = bankUserRepository.findById(accountRegistrationRequest.bankUser())
                                .orElseThrow(() -> new ResourceNotFoundException("Bank User not found!"));

        Account account = new Account();
        account.setAccountBalance(accountRegistrationRequest.accountBalance());
        account.setBankUser(bankUser);
        
        accountRepository.save(account);
    }

    
}
