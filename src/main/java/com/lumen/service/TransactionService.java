package com.lumen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lumen.dao.TransactionRepository;
import com.lumen.entities.Transaction;

import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction) {
        try {
            // Placeholder logic: Just save the transaction to the database
            return transactionRepository.save(transaction);
        } catch (Exception e) {
            // Log the exception and handle it appropriately
            // You might want to use a logging framework like SLF4J
            System.err.println("Transaction creation failed: " + e.getMessage());

            // Rethrow the exception or wrap it in a custom exception if needed
            throw new RuntimeException("Transaction creation failed", e);
        }
    }

    public Transaction getTransactionById(Long transactionId) {
        try {
            Optional<Transaction> optionalTransaction = transactionRepository.findById(transactionId);
            return optionalTransaction.orElse(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve transaction: " + e.getMessage());
            throw new RuntimeException("Failed to retrieve transaction", e);
        }
    }

    public Iterable<Transaction> getAllTransactions() {
        try {
            return transactionRepository.findAll();
        } catch (Exception e) {
            System.err.println("Failed to retrieve transactions: " + e.getMessage());
            throw new RuntimeException("Failed to retrieve transactions", e);
        }
    }

}

