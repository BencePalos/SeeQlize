package com.bencep.seeqlize_backend.users.controllers;

import com.bencep.seeqlize_backend.common.ErrorResponseDto;
import com.bencep.seeqlize_backend.common.LoginResponseDto;
import com.bencep.seeqlize_backend.common.RegisterResponseDto;
import com.bencep.seeqlize_backend.users.dtos.LoginDto;
import com.bencep.seeqlize_backend.users.models.User;
import com.bencep.seeqlize_backend.users.repositories.UserRepository;
import com.bencep.seeqlize_backend.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public  AuthController(UserService userService, UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User userToRegister){
        try{
            userService.validateRegistration(userToRegister);
            return ResponseEntity.ok(new RegisterResponseDto("Registration Successful"));
        }catch(ResponseStatusException ex){
            return ResponseEntity.status(400).body(new ErrorResponseDto(ex.getReason()));
        }

    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody LoginDto loginDto){
        try {
            Long loggedInUserId = userService.validateLogin(loginDto);
            return ResponseEntity.ok(new LoginResponseDto("Login Successful", loggedInUserId));
        }catch(ResponseStatusException ex){
            return ResponseEntity.status(400).body(new ErrorResponseDto(ex.getReason()));
        }

    }
}
