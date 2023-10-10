package com.stock_mgmt.stock_mgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stock_mgmt.stock_mgmt.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}