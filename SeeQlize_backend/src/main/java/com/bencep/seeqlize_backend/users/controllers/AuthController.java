package com.bencep.seeqlize_backend.users.controllers;

import com.bencep.seeqlize_backend.users.models.User;
import com.bencep.seeqlize_backend.users.repositories.UserRepository;
import com.bencep.seeqlize_backend.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        }catch(ResponseStatusException err){
            return ResponseEntity.status(400).body(err.getReason());
        }
        return ResponseEntity.ok("Registration successful");
    }
}
