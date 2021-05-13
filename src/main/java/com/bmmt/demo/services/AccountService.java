package com.bmmt.demo.services;

import com.bmmt.demo.entities.Account;
import com.bmmt.demo.entities.Transaction;
import com.bmmt.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.bmmt.demo.repositories.AccountRepository;

import java.time.LocalDate;


@Service
public class AccountService {
    private final AccountRepository accountsRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public AccountService(AccountRepository accountsRepository, TransactionRepository transactionRepository) {
        this.accountsRepository = accountsRepository;
        this.transactionRepository = transactionRepository;
    }

    public Iterable<Account> index() {
        return accountsRepository.findAll();
    }

    public Account show(Long id) {
        return accountsRepository.findById(id).get();
    }

    public Iterable<Account> findAllUserAccounts(Long userId) {
        return accountsRepository.findAccountByUserId(userId);
    }

    public Account findByAccountNum(Long accountNumber) {
        return accountsRepository.findAccountByAccountNumber(accountNumber);
    }

    public Account create(Account account) {
        return accountsRepository.save(account);
    }

    public Boolean delete(Account account) {
        accountsRepository.delete(account);
        return true;
    }

    public Account findOneUserAccount(Long userId, String accountName) {
        return accountsRepository.findUserCheckingAccount(userId, accountName);
    }

//    public Account findUserChecking(Long userId, String accountName) {
//        return accountsRepository.findUserCheckingAccount(userId, accountName);
//    }
//
//    public Account findUserSavings(Long userId, String accountName) {
//        return accountsRepository.findUserSavingsAccount(userId, accountName);
//    }
//
//    public Account findUserInvestment(Long userId, String accountName) {
//        return accountsRepository.findUserInvestmentAccount(userId, accountName);
//    }

    public Account update(Long id, Account account) {
        Account original = accountsRepository.findById(id).get();
        original.setAccountType(account.getAccountType());
        original.setBalance(account.getBalance());
        original.setAccountNumber(account.getAccountNumber());
        original.setUserId(account.getUserId());
        return accountsRepository.save(original);
    }

    public Account deposit(Long accountNumber, Double amount) {
        Account ogAccount = accountsRepository.findAccountByAccountNumber(accountNumber);
        ogAccount.setBalance(ogAccount.getBalance() + amount);
        return accountsRepository.save(ogAccount);
    }

    public Account withdraw(Long accountNumber, Double amount) {
        Account ogAccount = accountsRepository.findAccountByAccountNumber(accountNumber);
        ogAccount.setBalance(ogAccount.getBalance() - amount);
        return accountsRepository.save(ogAccount);
    }


//    public Account transfer(Double amount, Long accountOne, Long accountTwo) {
//    }
}