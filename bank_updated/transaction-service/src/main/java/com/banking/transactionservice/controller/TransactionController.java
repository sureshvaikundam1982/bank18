package com.banking.transactionservice.controller;

import org.springframework.web.bind.annotation.*;
import com.banking.transactionservice.model.Transaction;
import com.banking.transactionservice.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return service.createTransaction(transaction);
    }
}
