package com.example.carssale.service.Impl;

import com.example.carssale.exception.OfferNotFoundException;
import com.example.carssale.messages.Messages;
import com.example.carssale.model.binding.CreateOfferBindingModel;
import com.example.carssale.model.binding.OfferEditBindingModel;
import com.example.carssale.model.dto.OfferDTO;
import com.example.carssale.model.entity.FeatureEntity;
import com.example.carssale.model.entity.OfferEntity;
import com.example.carssale.model.entity.PictureEntity;
import com.example.carssale.model.entity.UserEntity;
import com.example.carssale.model.service.CreateOfferServiceModel;
import com.example.carssale.model.service.OfferEditServiceModel;
import com.example.carssale.repository.FeatureRepository;
import com.example.carssale.repository.OfferRepository;
import com.example.carssale.repository.PictureRepository;
import com.example.carssale.repository.UserRepository;
import com.example.carssale.service.CloudinaryService;
import com.example.carssale.service.FeatureService;
import com.example.carssale.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final CloudinaryService cloudinaryService;
    private final PictureRepository pictureRepository;
    private final UserRepository userRepository;
    private final FeatureRepository featureRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, CloudinaryService cloudinaryService, PictureRepository pictureRepository, UserRepository userRepository, FeatureService featureService, FeatureRepository featureRepository) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.cloudinaryService = cloudinaryService;
        this.pictureRepository = pictureRepository;
        this.userRepository = userRepository;
        this.featureRepository = featureRepository;
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

        createOfferBindingModel
                .getFeatures()
                .forEach(feature -> {

                    FeatureEntity byName = featureRepository.findByName(feature);

                    if (byName != null){
                        newOffer.getFeatures().add(byName);
                    }
                });


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

    @Override
    public OfferEditServiceModel changeOffer(OfferEditBindingModel offerEditBindingModel, Long offerId) {

        OfferEditServiceModel offerEditServiceModel = modelMapper.map(offerEditBindingModel, OfferEditServiceModel.class);

        OfferEntity offerEntityById = offerRepository.getById(offerId);

       if (offerEntityById.getId() != null) {
        offerEntityById
                .setModification(offerEditServiceModel.getModification())
                .setPower(offerEditServiceModel.getPower())
                .setKilometer(offerEditServiceModel.getKilometer())
                .setPrice(offerEditServiceModel.getPrice())
                .setPriceType(offerEditServiceModel.getPriceType())
                .setVehicleStatus(offerEditServiceModel.getVehicleStatus())
                .setExteriorColor(offerEditServiceModel.getExteriorColor())
                .setModified(Instant.now());
       }else {
           throw new OfferNotFoundException(offerId, Messages.getOfferNotFound(String.valueOf(offerId)));
       }

        OfferEntity offerEntitySaved = offerRepository.save(offerEntityById);

        return modelMapper.map(offerEntitySaved, OfferEditServiceModel.class);
    }

    @Override
    public void doUpdateOfOffersViews(Long offerId) {
        OfferEntity byId = offerRepository.getById(offerId);

        byId.setViews(byId.getViews()+1);

        offerRepository.save(byId);
    }

    @Override
    public List<OfferDTO> getAllOwnerOffers(String email) {
        Optional<UserEntity> byEmail = userRepository.findByEmail(email);

        if (byEmail.isPresent()) {
            List<OfferEntity> allByUserEmail = offerRepository.findAllByUserEmail(byEmail.get().getEmail());

            return allByUserEmail
                    .stream()
                    .map(this::asOfferDTO)
                    .collect(Collectors.toList());
        }

        throw new UsernameNotFoundException("We couldn't found the username!");

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
