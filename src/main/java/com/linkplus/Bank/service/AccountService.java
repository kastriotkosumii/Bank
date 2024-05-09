package com.linkplus.Bank.service;

import com.linkplus.Bank.payload.request.Account.AccountDepositeRequest;
import com.linkplus.Bank.payload.request.Account.AccountRegistrationRequest;
import com.linkplus.Bank.payload.request.Account.AccountWithdrawRequest;

public interface AccountService {
    void addAccount(AccountRegistrationRequest accountRegistrationRequest);
    void deposite(AccountDepositeRequest accountDepositeRequest);
    void withdraw(AccountWithdrawRequest accountWithdrawRequest);
}
