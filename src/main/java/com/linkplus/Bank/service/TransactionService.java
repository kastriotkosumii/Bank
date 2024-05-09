package com.linkplus.Bank.service;

import com.linkplus.Bank.payload.request.Transaction.FundTransferRequest;

public interface TransactionService {
    void fundTransfer(FundTransferRequest fundTransfer);
}
