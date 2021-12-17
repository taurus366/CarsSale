package com.example.carssale.event;

public class OfferViewCountEvent {

    private final Long offerId;

    public OfferViewCountEvent(Long offerId) {
        this.offerId = offerId;
    }

    public Long getOfferId() {
        return offerId;
    }
}
