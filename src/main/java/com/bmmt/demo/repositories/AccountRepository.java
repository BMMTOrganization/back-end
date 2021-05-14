package com.bmmt.demo.repositories;

import com.bmmt.demo.entities.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    //@Query("Select a from Account a where a.accountNumber = ?1")
    Account findByAccountNumber(Long accountNumber);

    @Query("Select a from Account a where a.userId = ?1")
    Iterable<Account> findAccountByUserId(Long userId);

    @Query("Select a from Account a where a.userId = ?1 and a.accountType = ?2")
    Account findUserCheckingAccount(Long userId, String accountName);

//    @Query("delete from Account a where a.accountNumber = ?1")
    @Transactional
    void deleteAccountByAccountNumber(Long accountNumber);

//    @Query("Select a from Account a where a.userId = ?1 and a.accountType = 'Savings'")
//    Account findUserSavingsAccount(Long userId, String accountName);
//
//    @Query("Select a from Account a where a.userId = ?1 and a.accountType = 'Investment'")
//    Account findUserInvestmentAccount(Long userId, String accountName);
}
