package com.example.carssale.service.Impl;

import com.example.carssale.model.dto.OfferDTO;
import com.example.carssale.model.entity.OfferEntity;
import com.example.carssale.repository.OfferRepository;
import com.example.carssale.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OfferDTO> getAllOffers() {

        return  offerRepository.findAll()
                .stream()
                .map(this::asOfferDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OfferDTO getOfferById(Long id) {

        return asOfferDTO(offerRepository.getById(id));
    }


    private OfferDTO asOfferDTO(OfferEntity offer){
        OfferDTO offerDTO = modelMapper.map(offer, OfferDTO.class);

        offerDTO.setBrand(offer.getModel().getBrand().getBrandName());
        offerDTO.setFrom(offer.getUser().getCityVillage().getCityVillageName().toUpperCase(Locale.ROOT));

        return offerDTO;

    }
}
