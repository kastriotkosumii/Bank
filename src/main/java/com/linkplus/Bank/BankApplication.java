package com.linkplus.Bank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.linkplus.Bank.model.BankUser;
import com.linkplus.Bank.repository.AccountRepository;
import com.linkplus.Bank.repository.BankUserRepository;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	@Bean
    CommandLineRunner runner(
            BankUserRepository bankUserRepository,
			AccountRepository accountRepository) {
        return args -> {
            addBankUser(bankUserRepository);
        };
    }

	private static void addBankUser(BankUserRepository bankUserRepository){

		BankUser bankUser = new BankUser();
		bankUser.setEmail("John.Doe@gmail.com");
		bankUser.setFistName("John");
		bankUser.setLastName("Doe");

		BankUser bankUser2 = new BankUser();
		bankUser2.setEmail("filan.fisteku@gmail.com");
		bankUser2.setFistName("Filan");
		bankUser2.setLastName("Fisteku");
		
		bankUserRepository.save(bankUser);
		bankUserRepository.save(bankUser2);

	}

}
