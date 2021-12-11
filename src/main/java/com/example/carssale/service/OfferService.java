package com.example.carssale.service;

import com.example.carssale.model.dto.OfferDTO;

import java.util.List;

public interface OfferService {

    List<OfferDTO> getAllOffers();
    OfferDTO getOfferById(Long id);
}
