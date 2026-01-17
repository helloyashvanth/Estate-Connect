package com.estateconnect.backend.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.estateconnect.backend.dto.SignupRequest;
import com.estateconnect.backend.dto.SignupResponse;
import com.estateconnect.backend.exception.UserAlreadyExists;
import com.estateconnect.backend.model.User;
import com.estateconnect.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public SignupResponse signup(SignupRequest req) {
        if (userRepository.existsByUsername(req.getUsername())) {
            throw new UserAlreadyExists("Username already exists");
        }

        User user = new User();
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setMobileNumber(req.getMobileNumber());
        user.setRole(req.getRole());
        user.setPassword(new BCryptPasswordEncoder().encode(req.getPassword()));

        userRepository.save(user);

        SignupResponse response = new SignupResponse();
        response.setUsername(user.getUsername());
        response.setRole(user.getRole());

        return response;
    }
}