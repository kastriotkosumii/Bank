package com.linkplus.Bank.payload.request.Account;

public record AccountWithdrawRequest(
    Long accountId,
    Double ammount
) {
    
}
