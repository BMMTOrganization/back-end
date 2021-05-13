package com.bmmt.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate transactionDate;
    private Long accountOne;
    private Long accountTwo;
    private String transactionType;
    private Double amount;
    private Long userId;

    public Transaction() {
    }

    public Transaction(LocalDate transactionDate, Long accountOne, Long accountTwo, String transactionType, Double amount, Long userId) {
        this.transactionDate = transactionDate;
        this.accountOne = accountOne;
        this.accountTwo = accountTwo;
        this.transactionType = transactionType;
        this.amount = amount;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Long getAccountOne() {
        return accountOne;
    }

    public void setAccountOne(long accountOne) {
        this.accountOne = accountOne;
    }

    public Long getAccountTwo() {
        return accountTwo;
    }

    public void setAccountTwo(long accountTwo) {
        this.accountTwo = accountTwo;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
