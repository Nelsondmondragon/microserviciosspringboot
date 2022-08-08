package com.invoice.microinvoice.controller;

import com.invoice.microinvoice.entities.Invoice;
import com.invoice.microinvoice.repository.InvoiceRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {


    @Autowired
    InvoiceRespository invoiceRepository;

    @GetMapping("")
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> findById(@PathVariable Long id) {
        return ResponseEntity.ok(invoiceRepository.findById(id).get());
    }

    @PutMapping("")
    public ResponseEntity<Invoice> save(@RequestBody Invoice input) {
        return ResponseEntity.ok(invoiceRepository.save(input));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        invoiceRepository.deleteById(id);
    }
}
