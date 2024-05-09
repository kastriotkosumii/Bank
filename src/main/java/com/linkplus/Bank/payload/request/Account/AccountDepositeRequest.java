package com.linkplus.Bank.payload.request.Account;

public record AccountDepositeRequest(
    Long accountId,
    Double ammount
) {
    
}
