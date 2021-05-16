package com.bmmt.demo.services;
import com.bmmt.demo.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bmmt.demo.repositories.AccountRepository;


@Service
public class AccountService {
    private final AccountRepository accountsRepository;

    @Autowired
    public AccountService(AccountRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
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
        return accountsRepository.findByAccountNumber(accountNumber);
    }

    public Account create(Account account) {
        return accountsRepository.save(account);
    }

    public Boolean delete(Account account) {
        accountsRepository.delete(account);
        return true;
    }

    public void deleteByAccountNumber(Long accountNumber) {
        accountsRepository.deleteAccountByAccountNumber(accountNumber);
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

    public Account deposit(Long accountNumber, Account account) {
        Account ogAccount = accountsRepository.findByAccountNumber(accountNumber);
        ogAccount.setAccountNumber(account.getAccountNumber());
        ogAccount.setAccountType(account.getAccountType());
        ogAccount.setUserId(account.getUserId());
        ogAccount.setTransactions(account.getTransactions());
        ogAccount.setBalance(account.getBalance());
        return accountsRepository.save(ogAccount);
    }

    public Account withdraw(Long accountNumber, Account account) {
        Account ogAccount = accountsRepository.findByAccountNumber(accountNumber);
        ogAccount.setAccountNumber(account.getAccountNumber());
        ogAccount.setAccountType(account.getAccountType());
        ogAccount.setUserId(account.getUserId());
        ogAccount.setTransactions(account.getTransactions());
        ogAccount.setBalance(account.getBalance());
        return accountsRepository.save(ogAccount);
    }

    public void deleteById(Long id) {
        accountsRepository.deleteById(id);
    }


//    public Account transfer(Double amount, Long accountOne, Long accountTwo) {
//    }
}