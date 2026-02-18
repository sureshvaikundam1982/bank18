package com.banking.transactionservice.service;

import org.springframework.stereotype.Service;
import com.banking.transactionservice.repository.TransactionRepository;
import com.banking.transactionservice.model.Transaction;
import com.banking.transactionservice.feign.AccountClient;

@Service
public class TransactionService {

    private final TransactionRepository repository;
    private final AccountClient accountClient;

    public TransactionService(TransactionRepository repository, AccountClient accountClient) {
        this.repository = repository;
        this.accountClient = accountClient;
    }

    public Transaction createTransaction(Transaction transaction) {

        Object account = accountClient.getAccountById(transaction.getAccountId());

        if (account == null) {
            throw new RuntimeException("Account not found");
        }

        return repository.save(transaction);
    }
}
