package com.banking.transactionservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountId;
    private Double amount;
    private String type;

    public Transaction() {}

    public Transaction(Long accountId, Double amount, String type) {
        this.accountId = accountId;
        this.amount = amount;
        this.type = type;
    }

    public Long getId() { return id; }
    public Long getAccountId() { return accountId; }
    public Double getAmount() { return amount; }
    public String getType() { return type; }

    public void setId(Long id) { this.id = id; }
    public void setAccountId(Long accountId) { this.accountId = accountId; }
    public void setAmount(Double amount) { this.amount = amount; }
    public void setType(String type) { this.type = type; }
}
