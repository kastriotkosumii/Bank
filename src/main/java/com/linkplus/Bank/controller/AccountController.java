package com.linkplus.Bank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linkplus.Bank.payload.request.Account.AccountDepositeRequest;
import com.linkplus.Bank.payload.request.Account.AccountRegistrationRequest;
import com.linkplus.Bank.payload.request.Account.AccountWithdrawRequest;
import com.linkplus.Bank.service.AccountService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping(path = "api/v1/account")
@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public void addAccount(@RequestBody AccountRegistrationRequest accountRegistrationRequest) {
        accountService.addAccount(accountRegistrationRequest);
    }
        
    @PostMapping("deposit")
    public void deposit(@RequestBody AccountDepositeRequest accountDepositeRequest) {
        accountService.deposite(accountDepositeRequest);
    }

    @PostMapping("withdraw")
    public void withdraw(@RequestBody AccountWithdrawRequest accountWithdrawRequest) {
        accountService.withdraw(accountWithdrawRequest);
    }
    
}
