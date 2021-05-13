package com.bmmt.demo.controllers;

import com.bmmt.demo.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bmmt.demo.services.AccountService;

@CrossOrigin("*")
@RestController
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/account")
    public Account create(Account account) {
        return accountService.create(account);
    }

    @DeleteMapping("/account/delete/{accountNumber}")
    public Boolean delete(Account account) {
        return accountService.delete(account);
    }

    @GetMapping("/account/all")
    public Iterable<Account> getAll() {
        return accountService.index();
    }

//    @GetMapping("/account/{id}")
//    public Account getById(@PathVariable Long id) {
//        return accountService.show(id);
//    }

    @GetMapping("/account/number/{accountNumber}")
    public Account getByAccountNumber(@PathVariable Long accountNumber) {
        return accountService.findByAccountNum(accountNumber);
    }

    @GetMapping("/account/user/{userId}")
    public Iterable<Account> getAllUserAccounts(@PathVariable Long userId) {
        return accountService.findAllUserAccounts(userId);
    }

    @GetMapping("/account/user/{userId}/{accountName}")
    public Account getUserSingleAccount(@PathVariable Long userId, @PathVariable String accountName) {
        return accountService.findOneUserAccount(userId, accountName);
    }


    @PutMapping("/account/{id}")
    public Account update(@PathVariable Long id, Account account) {
        return accountService.update(id, account);
    }

    @PutMapping("/account/deposit/{accountNumber}/")
    public Account depositFunds(@PathVariable Long accountNumber, Double amount) {
        return accountService.deposit(accountNumber, amount);
    }

    @PutMapping("/account/withdraw/{accountNumber}/{amount}")
    public Account withdrawFunds(@PathVariable Long accountNumber, @PathVariable Double amount) {
        return accountService.withdraw(accountNumber, amount);
    }

//    @PutMapping("/account/transfer/{accountOne}/{accountTwo}/{amount}")
//    public ResponseEntity<Account> transferFunds(@PathVariable Long accountOne, @PathVariable Long accountTwo, @PathVariable Double amount) {
//        return new ResponseEntity<>(accountService.transfer(amount, accountOne, accountTwo), HttpStatus.OK);
//    }
}