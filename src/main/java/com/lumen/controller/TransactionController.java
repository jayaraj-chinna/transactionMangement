package com.lumen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        try {
            Transaction createdTransaction = transactionService.createTransaction(transaction);
            return ResponseEntity.ok(createdTransaction);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Transaction creation failed: " + e.getMessage());
        }
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long transactionId) {
        try {
            Transaction transaction = transactionService.getTransactionById(transactionId);
            if (transaction != null) {
                return ResponseEntity.ok(transaction);
            } else {
                return ResponseEntity.status(404).body("Transaction not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to retrieve transaction: " + e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<Transaction>> getAllTransactions() {
        try {
            Iterable<Transaction> transactions = transactionService.getAllTransactions();
            return ResponseEntity.ok(transactions);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to retrieve transactions: " + e.getMessage());
        }
    }

}

