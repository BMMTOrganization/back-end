package com.bmmt.demo.controllers;

import com.bmmt.demo.entities.Transaction;
import com.bmmt.demo.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transaction/all")
    public ResponseEntity<Iterable<Transaction>> getAll() {
        return new ResponseEntity<>(transactionService.index(), HttpStatus.OK);
    }

    @GetMapping("/transaction/user/{userId}")
    public ResponseEntity<Iterable<Transaction>> getAllFromUser(@PathVariable Long userId) {
        return new ResponseEntity<>(transactionService.transactionsByUser(userId), HttpStatus.OK);
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable Long id) {
        return new ResponseEntity<>(transactionService.show(id), HttpStatus.OK);
    }

    @GetMapping("transaction/account/{accountOne}")
    public ResponseEntity<Iterable<Transaction>> getTransactionsByAccount(@PathVariable Long accountOne) {
        return new ResponseEntity<>(transactionService.transactionsByAccount(accountOne), HttpStatus.OK);
    }

    @PostMapping("/transaction")
    public ResponseEntity<Transaction> create(Transaction transaction) {
        return new ResponseEntity<>(transactionService.create(transaction), HttpStatus.CREATED);
    }

}
