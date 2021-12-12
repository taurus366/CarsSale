package com.example.carssale.service.Impl;

import com.example.carssale.model.binding.CreateOfferBindingModel;
import com.example.carssale.model.dto.OfferDTO;
import com.example.carssale.model.entity.OfferEntity;
import com.example.carssale.model.entity.PictureEntity;
import com.example.carssale.model.entity.UserEntity;
import com.example.carssale.model.service.CreateOfferServiceModel;
import com.example.carssale.repository.OfferRepository;
import com.example.carssale.repository.PictureRepository;
import com.example.carssale.repository.UserRepository;
import com.example.carssale.service.CloudinaryService;
import com.example.carssale.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final CloudinaryService cloudinaryService;
    private final PictureRepository pictureRepository;
    private final UserRepository userRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, CloudinaryService cloudinaryService, PictureRepository pictureRepository, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.cloudinaryService = cloudinaryService;
        this.pictureRepository = pictureRepository;
        this.userRepository = userRepository;
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

    @Override
    public CreateOfferServiceModel createOffer(CreateOfferBindingModel createOfferBindingModel, String sellerEmail) {

        CreateOfferServiceModel createOfferServiceModel = modelMapper.map(createOfferBindingModel,CreateOfferServiceModel.class);

        OfferEntity newOffer = modelMapper.map(createOfferServiceModel, OfferEntity.class);

        newOffer
                .setCreated(Instant.now())
                .setModified(Instant.now());

        UserEntity userEntity = userRepository.findByEmail(sellerEmail).orElseThrow(() -> new UsernameNotFoundException("User with that Email: "+ sellerEmail + " not found!"));

        newOffer
                .setUser(userEntity);


        List<PictureEntity> list = new ArrayList<>();

        createOfferBindingModel
                .getPicture()
                        .stream()
                                .filter(file -> !file.isEmpty())
                                        .forEach(picture -> {
                                            try {
                                                PictureEntity pictureEntity = createPictureEntity(picture);
                                                pictureEntity.setCreated(Instant.now());
                                                pictureEntity.setModified(Instant.now());
                                                list.add(pictureEntity);
                                            } catch (IOException e) {
//                                                e.printStackTrace();
                                            }
                                        });

        newOffer.setPictures(pictureRepository.saveAll(list));


        OfferEntity offerEntity = offerRepository
                .save(newOffer);


        return modelMapper.map(offerEntity,CreateOfferServiceModel.class);
    }

    @Override
    public boolean isOwnerTheOffer(long offerId, String userIdentifierEmail) {

        return offerRepository.getById(offerId).getUser().getEmail().equals(userIdentifierEmail);
    }

    @Override
    public void deleteOfferById(Long id) {
        offerRepository.deleteById(id);
    }

    @Override
    public void deleteFromOfferPicture(long parseLong, String publicId) {
//        OfferEntity byId = offerRepository
//                .getById(parseLong);
//        byId
//                .getPictures()
//                .forEach(pictureEntity -> {
//                    if (pictureEntity.getPublicId().equals(publicId)) {
//                        System.out.println("it is");
//                        byId.getPictures().remove(pictureEntity);
//                    }
//                });
        System.out.println(  offerRepository
                .findById(parseLong)
                .orElseThrow()
                .getPictures().size());

        List<PictureEntity> collect = offerRepository
                .findById(parseLong)
                .orElseThrow()
                .getPictures()
                .stream()
                .filter(pictureEntity -> !pictureEntity.getPublicId().equals(publicId))
                .collect(Collectors.toList());

        OfferEntity offerEntity = offerRepository
                .findById(parseLong)
                .orElseThrow();
        offerEntity.setPictures(collect);

//        System.out.println(byId.getPictures().size());

        offerRepository.save(offerEntity);
    }


    private PictureEntity createPictureEntity (MultipartFile file) throws IOException {
        CloudinaryImage upload = cloudinaryService.upload(file);

        return new PictureEntity()
                .setPublicId(upload.getPublicId())
                .setUrl(upload.getUrl());
    }


    private OfferDTO asOfferDTO(OfferEntity offer){
        OfferDTO offerDTO = modelMapper.map(offer, OfferDTO.class);

        offerDTO.setBrand(offer.getModel().getBrand().getBrandName());
        offerDTO.setFrom(offer.getUser().getCityVillage().getCityVillageName().toUpperCase(Locale.ROOT));

        return offerDTO;

    }
}
