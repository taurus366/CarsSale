package com.example.carssale.exception;

public class NotOwnerException extends RuntimeException{

    private final Long offerId;
    private final String reason;


    public NotOwnerException(Long offerId, String reason) {
        super(reason);
        this.offerId = offerId;
        this.reason = reason;
    }

    public Long getOfferId() {
        return offerId;
    }

    public String getReason() {
        return reason;
    }
}
