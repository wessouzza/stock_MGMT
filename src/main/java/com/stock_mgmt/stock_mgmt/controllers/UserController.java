package com.stock_mgmt.stock_mgmt.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stock_mgmt.stock_mgmt.entity.UserMd;
import com.stock_mgmt.stock_mgmt.services.UserService;

@RestController("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    List<UserMd> create(@RequestBody UserMd user){
        return userService.create(user);
    }

    @GetMapping
    List<UserMd> list(){
        return userService.list();
    }

    @PutMapping("{id}")
    List<UserMd> update(@PathVariable UUID id, @RequestBody UserMd user){
        return userService.update(id, user);
    }

    @DeleteMapping("{id}")
    List<UserMd> delete(@PathVariable UUID id){
        return userService.delete(id);
    }
}