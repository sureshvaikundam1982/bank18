package com.banking.accountservice.controller;

import com.banking.accountservice.repository.AccountRepository;
import org.springframework.web.bind.annotation.*;
import com.banking.accountservice.model.Account;
import com.banking.accountservice.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;
    private final AccountRepository repository;

    public AccountController(AccountService service,
                             AccountRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return service.createAccount(account);
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}/debit/{amount}")
    public Account debit(@PathVariable Long id,
                         @PathVariable Double amount) {

        Account account = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);
        return repository.save(account);
    }

    @PutMapping("/{id}/credit/{amount}")
    public Account credit(@PathVariable Long id,
                          @PathVariable Double amount) {

        Account account = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.setBalance(account.getBalance() + amount);
        return repository.save(account);
    }
}
