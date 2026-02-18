package com.banking.fundtransfer.model;

public class TransferRequest {

    private Long fromAccountId;
    private Long toAccountId;
    private Double amount;

    public Long getFromAccountId() { return fromAccountId; }
    public Long getToAccountId() { return toAccountId; }
    public Double getAmount() { return amount; }

    public void setFromAccountId(Long fromAccountId) { this.fromAccountId = fromAccountId; }
    public void setToAccountId(Long toAccountId) { this.toAccountId = toAccountId; }
    public void setAmount(Double amount) { this.amount = amount; }
}
