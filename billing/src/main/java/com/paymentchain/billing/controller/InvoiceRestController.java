/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paymentchain.billing.controller;

import com.paymentchain.billing.entities.InvoiceEntity;
import com.paymentchain.billing.repository.InvoiceRespository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nelso
 */
@RestController
@RequestMapping("/billing")
public class InvoiceRestController {

    @Autowired
    private InvoiceRespository invoiceRespository;

    @GetMapping
    public List<InvoiceEntity> findAll() {

        return invoiceRespository.findAll();
    }

    @GetMapping("/{id}")
    public InvoiceEntity get(long id) {
        return null;
    }

    @PutMapping()
    public ResponseEntity<?> put(@PathVariable long id, @RequestBody InvoiceEntity invoiceEntity) {
        return null;
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody InvoiceEntity invoiceEntity) {
        return ResponseEntity.ok(invoiceRespository.save(invoiceEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        return null;
    }
}
