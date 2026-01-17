package com.estateconnect.backend.service;

import com.estateconnect.backend.dto.SignupRequest;
import com.estateconnect.backend.dto.SignupResponse;

public interface AuthService {
    SignupResponse signup(SignupRequest req);
}