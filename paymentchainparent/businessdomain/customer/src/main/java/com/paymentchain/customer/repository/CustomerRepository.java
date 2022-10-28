/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paymentchain.customer.repository;

import com.paymentchain.customer.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author nelso
 */
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Query(value = "Select * From customer c where c.code = ?1", nativeQuery = true)
    public CustomerEntity findByCode(String code);

}
