package com.bencep.seeqlize_backend.users.services;

import com.bencep.seeqlize_backend.users.dtos.LoginDto;
import com.bencep.seeqlize_backend.users.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public void validateRegistration(User newUser);
    public Long validateLogin(LoginDto loginDto);
}
