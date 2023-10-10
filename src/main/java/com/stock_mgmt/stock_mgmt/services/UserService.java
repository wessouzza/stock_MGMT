package com.stock_mgmt.stock_mgmt.services;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stock_mgmt.stock_mgmt.entity.User;
import com.stock_mgmt.stock_mgmt.exception.ErrorMessge;
import com.stock_mgmt.stock_mgmt.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> create(User user){
        //var password = user.getPassword();
        userRepository.save(user);
        return list();
    }

    public List<User> list(){
        Sort sort = Sort.by("id").ascending();
        return userRepository.findAll(sort);
    }

    public List<User> update(UUID id, User user){
        userRepository.findById(id).ifPresentOrElse((userExists) -> {
            user.setId(id);
            userRepository.save(user);
        }, () -> {
            throw new ErrorMessge("User nof found.");
        });
        return list();
    }

    public List<User> delete(UUID id){
        userRepository.deleteById(id);
        return list();
    }
}