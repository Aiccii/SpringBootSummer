package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {



    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }


    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id).orElseThrow( () -> new RuntimeException("Account not found"));
    }

    @GetMapping("/ebe")
    public String ff(){
        return "ebe";
    }


    @PostMapping("/{id}/withdraw")
    public Account getWithdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return accountService.withdraw(id, amount);
    }


    @PostMapping("/{id}/deposit")
    public Account getDeposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return accountService.deposit(id, amount);
    }




}
