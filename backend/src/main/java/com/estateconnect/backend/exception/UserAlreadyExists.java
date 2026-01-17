package com.estateconnect.backend.exception;

public class UserAlreadyExists extends RuntimeException {
    public UserAlreadyExists(String str) {
        super(str);
    }
}