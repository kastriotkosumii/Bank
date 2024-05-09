package com.linkplus.Bank.payload.request.Account;

public record AccountRegistrationRequest(
    Double accountBalance, 
    Long bankUser
) {
    
}
