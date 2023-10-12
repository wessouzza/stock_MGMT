package com.stock_mgmt.stock_mgmt.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stock_mgmt.stock_mgmt.entity.UserMd;

public interface UserRepository extends JpaRepository<UserMd, UUID> {
    
    Optional<UserMd> findByName(String username);
}