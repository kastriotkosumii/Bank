package com.linkplus.Bank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linkplus.Bank.payload.request.Transaction.FundTransferRequest;
import com.linkplus.Bank.service.TransactionService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping(path = "api/v1/transaction")
@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public void fondTransfer(@RequestBody FundTransferRequest fundTransferRequest) {
        transactionService.fundTransfer(fundTransferRequest);
    }
    
}
