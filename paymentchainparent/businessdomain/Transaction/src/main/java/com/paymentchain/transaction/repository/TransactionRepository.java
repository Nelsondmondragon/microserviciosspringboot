/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paymentchain.transaction.repository;

import com.paymentchain.transaction.entities.TransactionEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author nelso
 */
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    @Query("SELECT t FROM TransactionEntity t WHERE t.ibanAccount = ?1")
    List<TransactionEntity> findByIbanAccount(String ibanAccount);

//    List<TransactionEntity> findByReference(String reference);
}
