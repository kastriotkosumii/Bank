package com.linkplus.Bank.service.impl;

import org.springframework.stereotype.Service;

import com.linkplus.Bank.repository.BankRepository;
import com.linkplus.Bank.service.BankService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BankServiceImp implements BankService {

    private final BankRepository bankRepository;

    @Override
    public Double getAllFees(Long bankId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllFees'");
    }    
    
}
