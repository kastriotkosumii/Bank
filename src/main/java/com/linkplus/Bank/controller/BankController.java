package com.linkplus.Bank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linkplus.Bank.service.BankService;

import lombok.RequiredArgsConstructor;


@RequestMapping(path = "api/v1/bank")
@RestController
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;

}
