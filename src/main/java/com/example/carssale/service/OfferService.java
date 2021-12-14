package com.example.carssale.service;

import com.example.carssale.model.binding.CreateOfferBindingModel;
import com.example.carssale.model.binding.OfferEditBindingModel;
import com.example.carssale.model.dto.OfferDTO;
import com.example.carssale.model.service.CreateOfferServiceModel;
import com.example.carssale.model.service.OfferEditServiceModel;

import java.util.List;

public interface OfferService {

    List<OfferDTO> getAllOffers();
    OfferDTO getOfferById(Long id);
    CreateOfferServiceModel createOffer(CreateOfferBindingModel createOfferBindingModel, String sellerUsername);

    boolean isOwnerTheOffer(long offerId, String userIdentifierEmail);

    void deleteOfferById(Long id);

    void deleteFromOfferPicture(long parseLong, String publicId);

    OfferEditServiceModel changeOffer(OfferEditBindingModel offerEditBindingModel, Long offerId);
}
