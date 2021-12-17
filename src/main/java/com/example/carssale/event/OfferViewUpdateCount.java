package com.example.carssale.event;

import com.example.carssale.service.OfferService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OfferViewUpdateCount {

    private final OfferService offerService;

    public OfferViewUpdateCount(OfferService offerService) {
        this.offerService = offerService;
    }

    @EventListener(OfferViewCountEvent.class)
    public void updateOfferViewsCount(OfferViewCountEvent offerViewCountEvent) {

        offerService.doUpdateOfOffersViews(offerViewCountEvent.getOfferId());
    }
}
