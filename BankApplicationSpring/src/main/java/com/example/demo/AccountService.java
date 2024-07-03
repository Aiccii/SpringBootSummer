package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // creates a new account
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }


    // returns the account if it exists
    public Optional<Account> getAccount(Long id) {
        return accountRepository.findById(id);
    }


    // a simple deposit function
    public Account deposit(Long id, double amount) {
        Account account = getAccount(id).orElseThrow( () -> new RuntimeException("Account not found"));

        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);

    }


    public Account withdraw(Long id, double amount) {
        // tries to find the account if not it will throw an error
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));

        // this code throws an error if you want to get more than you have
        if (account.getBalance() < amount) {
            throw new RuntimeException("not enough funds, you are poor");
        }

        // if the above if statement does not throw an error, it will set the balance and save everything
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account); // saves everything in the database

    }


}
