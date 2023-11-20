package com.stock_mgmt.stock_mgmt.repository;

import com.stock_mgmt.stock_mgmt.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserDetails findByUsername(String username);
    //UserEntity findByUserName(String username);
}
