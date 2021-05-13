package com.bmmt.demo.repositories;

import com.bmmt.demo.entities.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    @Query("Select t from Transaction t where t.accountOne = ?1 order by t.transactionDate desc")
    Iterable<Transaction> findByAccountOne(Long accountOne);

    @Query("Select t from Transaction t where t.userId = ?1 order by t.id desc")
    Iterable<Transaction> findByUserId(Long userId);
}
