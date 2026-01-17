package com.estateconnect.backend.dto;

import com.estateconnect.backend.model.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {
    private String username;
    private String email;
    private String mobileNumber;
    private Role role;
    private String password;
}