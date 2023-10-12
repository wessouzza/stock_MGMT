package com.stock_mgmt.stock_mgmt.services;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stock_mgmt.stock_mgmt.entity.UserMd;
import com.stock_mgmt.stock_mgmt.exception.ErrorMessge;
import com.stock_mgmt.stock_mgmt.repository.UserRepository;

@Service
public class UserService {
    final private UserRepository userRepository;
    
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserMd> create(UserMd user){
        //var password = user.getPassword();
        userRepository.save(user);
        return list();
    }

    public List<UserMd> list(){
        Sort sort = Sort.by("id").ascending();
        return userRepository.findAll(sort);
    }

    public List<UserMd> update(UUID id, UserMd user){
        userRepository.findById(id).ifPresentOrElse((userExists) -> {
            user.setId(id);
            userRepository.save(user);
        }, () -> {
            throw new ErrorMessge("User nof found.");
        });
        return list();
    }

    public List<UserMd> delete(UUID id){
        userRepository.deleteById(id);
        return list();
    }
}