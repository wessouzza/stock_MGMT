package com.stock_mgmt.stock_mgmt.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stock_mgmt.stock_mgmt.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    
    Optional<User> findByName(String username);
}