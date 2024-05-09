package com.linkplus.Bank.service;

import com.linkplus.Bank.payload.request.BankUser.BankUserRegistrationRequest;

public interface BankUserService {
    void addBankUser(BankUserRegistrationRequest bankUserRegistrationRequest);
}
