package com.stock_mgmt.stock_mgmt.controllers;

import com.stock_mgmt.stock_mgmt.dto.AuthDto;
import com.stock_mgmt.stock_mgmt.dto.RegisterDto;
import com.stock_mgmt.stock_mgmt.entity.UserEntity;
import com.stock_mgmt.stock_mgmt.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDto data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var authentication = this.authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto data){
        if(this.userRepository.findByUsername(data.username()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String passwordEncripted = new BCryptPasswordEncoder().encode(data.password());
        UserEntity newUser = new UserEntity(data.username(), passwordEncripted, data.role());
        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
