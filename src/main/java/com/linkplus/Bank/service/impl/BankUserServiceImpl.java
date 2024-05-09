package com.linkplus.Bank.service.impl;

import org.springframework.stereotype.Service;

import com.linkplus.Bank.model.BankUser;
import com.linkplus.Bank.payload.request.BankUser.BankUserRegistrationRequest;
import com.linkplus.Bank.repository.BankUserRepository;
import com.linkplus.Bank.service.BankUserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BankUserServiceImpl implements BankUserService {

    private final BankUserRepository bankUserRepository; 

    @Override
    public void addBankUser(BankUserRegistrationRequest bankUserRegistrationRequest) {
        BankUser bankUser = new BankUser();
        bankUser.setEmail(bankUserRegistrationRequest.email());
        bankUser.setFistName(bankUserRegistrationRequest.fistName());
        bankUser.setLastName(bankUserRegistrationRequest.lastName());

        bankUserRepository.save(bankUser);
    }
    
}
