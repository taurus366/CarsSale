package com.example.carssale.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Offer not found!")
public class OfferNotFoundException extends RuntimeException{

    private final Long offerId;
    private final String reason;

    public OfferNotFoundException(Long offerId, String reason) {
        super(reason + offerId);
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
