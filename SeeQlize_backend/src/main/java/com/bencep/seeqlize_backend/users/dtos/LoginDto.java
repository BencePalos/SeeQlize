package com.bencep.seeqlize_backend.users.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginDto {
    public String username;
    public String password;
}
