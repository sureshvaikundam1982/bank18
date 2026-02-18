package com.banking.fundtransfer.service;

import org.springframework.stereotype.Service;

import com.banking.fundtransfer.model.TransferRequest;
import com.banking.fundtransfer.feign.AccountClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class FundTransferService {

    private final AccountClient accountClient;

    public FundTransferService(AccountClient accountClient) {
        this.accountClient = accountClient;
    }

    @CircuitBreaker(name = "accountService", fallbackMethod = "fallbackTransfer")
    public String transfer(TransferRequest request) {

        Object from = accountClient.getAccount(request.getFromAccountId());
        Object to = accountClient.getAccount(request.getToAccountId());

        if (from == null || to == null) {
            throw new RuntimeException("Invalid account");
        }

        accountClient.debit(request.getFromAccountId(), request.getAmount());
        accountClient.credit(request.getToAccountId(), request.getAmount());

        return "Transfer Successful";
    }

    // 🔴 Fallback method
    public String fallbackTransfer(TransferRequest request, Exception ex) {
        return "Account Service is currently unavailable. Transfer cannot be completed.";
    }
}
