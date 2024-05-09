package com.linkplus.Bank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linkplus.Bank.service.BankService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping(path = "api/v1/bank")
@RestController
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;

    @GetMapping
    public Double getAllFee(@RequestParam String param) {
        return bankService.getAllFees();
    }
    
    
}
