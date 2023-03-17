package com.bencep.seeqlize_backend.users.services;

import com.bencep.seeqlize_backend.users.dtos.LoginDto;
import com.bencep.seeqlize_backend.users.models.User;
import com.bencep.seeqlize_backend.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private static final String PW_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
    private static final Pattern pattern = Pattern.compile(PW_PATTERN);

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean validateUsername(String username) {
        Boolean doesExist = userRepository.existsByUsername(username);
        if (doesExist) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This username already exists");
        }
        if (username.length() < 4) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username must be at least 4 characters");
        }
        return true;
    }

    public boolean validatePassword(String password) {
        if (password.length() < 8) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password must be at least 8 characters long");
        }
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password must be at 8-20 characters, contain a number, one upper-, and one lower-case character");
        }
        return true;
    }

    @Override
    public void validateRegistration(User newUser) {
        String userName = newUser.getUsername();
        String password = newUser.getPassword();
        String email = newUser.getEmail();
        validateUsername(userName);
        validatePassword(password);
        User userToSave = new User(
                userName,
                passwordEncoder.encode(password),
                email
        );
        userRepository.save(userToSave);
    }

    @Override
    public boolean validateLogin(LoginDto loginDto){
        if(!userRepository.existsByUsername(loginDto.getUsername())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Incorrect credentials(username)");
        }
        User userToLogIn = userRepository.getUserByUsername(loginDto.getUsername());
        if(!passwordEncoder.matches(loginDto.getPassword(), userToLogIn.getPassword())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect credentials(password)");
        }

        return true;

    }
}
