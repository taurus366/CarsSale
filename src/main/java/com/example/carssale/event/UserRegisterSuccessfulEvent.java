package com.example.carssale.event;

public class UserRegisterSuccessfulEvent {

    private final String email;

    public UserRegisterSuccessfulEvent(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
