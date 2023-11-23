package com.lumen.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lumen.entities.*;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	Transaction save(Transaction transaction);

	Iterable<Transaction> findAll();
}

