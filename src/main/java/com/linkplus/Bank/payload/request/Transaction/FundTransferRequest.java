package com.linkplus.Bank.payload.request.Transaction;

public record FundTransferRequest(
    Long fromAccount,
    Long toAccount,
    Double ammount,
    String reason,
    String feeType
) {
    
}
