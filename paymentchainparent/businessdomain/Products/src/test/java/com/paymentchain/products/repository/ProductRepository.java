/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paymentchain.products.repository;

import com.paymentchain.products.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nelso
 */
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
    
}
