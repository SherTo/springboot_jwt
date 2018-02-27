package com.example.demo.controller;

public class UsernameIsExitedException extends Exception {
    public UsernameIsExitedException() {
    }

    public UsernameIsExitedException(String message) {
        super(message);
    }
}
