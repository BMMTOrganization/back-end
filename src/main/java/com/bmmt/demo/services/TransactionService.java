package com.bmmt.demo.services;

import com.bmmt.demo.entities.Transaction;
import com.bmmt.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


@Service
public class TransactionService {
    private final TransactionRepository transactionRepo;

    @Autowired
    public TransactionService(TransactionRepository transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    public Iterable<Transaction> index() {
        return transactionRepo.findAll();
    }

    public Iterable<Transaction> transactionsByUser (@PathVariable Long userId) {
        return transactionRepo.findByUserId(userId);
    }

    public Transaction create(Transaction transaction) {
        return transactionRepo.save(transaction);
    }

    public Transaction show(Long id) {
        return transactionRepo.findById(id).get();
    }

    public Iterable<Transaction> transactionsByAccount(Long accountOne) {
        return transactionRepo.findByAccountOne(accountOne);
    }
}
