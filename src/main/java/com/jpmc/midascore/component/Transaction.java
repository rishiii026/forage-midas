package com.jpmc.midascore.component; // ✅ Use your actual package name

public class Transaction {
    private Long senderId;
    private Long recipientId;
    private Double amount;

    // ✅ Default constructor (needed for JSON serialization)
    public Transaction() {}

    // ✅ Parameterized constructor (makes life easier)
    public Transaction(Long senderId, Long recipientId, Double amount) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.amount = amount;
    }

    // ✅ Getters and setters
    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
