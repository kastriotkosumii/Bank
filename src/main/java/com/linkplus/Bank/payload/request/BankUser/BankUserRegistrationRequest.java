package com.linkplus.Bank.payload.request.BankUser;

public record BankUserRegistrationRequest(
    String fistName,
    String lastName,
    String email
) {
    
}
