package com.banking.accountservice.service;

import org.springframework.stereotype.Service;
import com.banking.accountservice.repository.AccountRepository;
import com.banking.accountservice.model.Account;
import com.banking.accountservice.feign.UserClient;

@Service
public class AccountService {

    private final AccountRepository repository;
    private final UserClient userClient;

    public AccountService(AccountRepository repository, UserClient userClient) {
        this.repository = repository;
        this.userClient = userClient;
    }

    public Account createAccount(Account account) {

        // Call User Service to check if user exists
        Object user = userClient.getUserById(account.getUserId());

        if (user == null) {
            throw new RuntimeException("User not found. Cannot create account.");
        }

        return repository.save(account);
    }
}
