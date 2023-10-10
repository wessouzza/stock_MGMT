package com.stock_mgmt.stock_mgmt.config.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stock_mgmt.stock_mgmt.entity.User;
import com.stock_mgmt.stock_mgmt.exception.ErrorMessge;
import com.stock_mgmt.stock_mgmt.repository.UserRepository;

@Service
public class UserDetailsImp implements UserDetailsService {

    final UserRepository userRepository;

    public UserDetailsImp(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username)
            .orElseThrow(() -> new ErrorMessge("User " + username + " not found."));
        return user;
    }
    
}