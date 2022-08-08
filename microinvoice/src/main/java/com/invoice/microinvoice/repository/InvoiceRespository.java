package com.invoice.microinvoice.repository;

import com.invoice.microinvoice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRespository extends JpaRepository<Invoice, Long> {
}
