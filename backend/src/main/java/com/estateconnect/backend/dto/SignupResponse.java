package com.estateconnect.backend.dto;

import com.estateconnect.backend.model.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponse {
    private String username;
    private Role role;
}