package com.linkplus.Bank.service;

import com.linkplus.Bank.payload.request.Account.AccountRegistrationRequest;

public interface AccountService {
    void addAccount(AccountRegistrationRequest accountRegistrationRequest);
}
