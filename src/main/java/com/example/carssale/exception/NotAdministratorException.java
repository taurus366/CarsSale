package com.example.carssale.exception;

public class NotAdministratorException extends RuntimeException{

    private final String reason;


    public NotAdministratorException(String reason) {
        super(reason);
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}
