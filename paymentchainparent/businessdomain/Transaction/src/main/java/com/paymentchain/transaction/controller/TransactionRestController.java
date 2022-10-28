/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paymentchain.transaction.controller;

import com.paymentchain.transaction.entities.TransactionEntity;
import com.paymentchain.transaction.repository.TransactionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nelso
 */
@RestController
@RequestMapping("/transaction")
public class TransactionRestController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping
    public List<TransactionEntity> findAll() {
        return transactionRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody TransactionEntity input) {

//        long saldo = transactionRepository.findAll().stream()
//                .filter(transaction -> transaction.getIbanAccount().equals(input.getIbanAccount()))
//                .mapToLong(transaction -> transaction.getAmount())
//                .reduce(0, (a, b) -> a + b);
        long saldo = transactionRepository.findByIbanAccount(input.getIbanAccount()).stream()
                .mapToLong(transaction -> transaction.getAmount())
                .reduce(0, (a, b) -> a + b);

        if (saldo + input.getAmount() >= 0) {
            return new ResponseEntity<>(transactionRepository.save(input), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
