package com.example.carssale.service.Impl;

import com.example.carssale.model.binding.PictureUploadBindingModel;
import com.example.carssale.model.entity.OfferEntity;
import com.example.carssale.model.entity.PictureEntity;
import com.example.carssale.model.service.PictureUploadServiceModel;
import com.example.carssale.repository.OfferRepository;
import com.example.carssale.repository.PictureRepository;
import com.example.carssale.service.CloudinaryService;
import com.example.carssale.service.PictureService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final OfferRepository offerRepository;
    private final CloudinaryService cloudinaryService;

    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, OfferRepository offerRepository, CloudinaryService cloudinaryService) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.offerRepository = offerRepository;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public void deleteByPicturePublicId(String publicID) {
        pictureRepository.deleteAllByPublicId(publicID);
    }

    @Override
    public void uploadPicture(PictureUploadBindingModel pictureUploadBindingModel, Long offerId) throws IOException {

        PictureUploadServiceModel pictureUploadServiceModel = modelMapper.map(pictureUploadBindingModel,PictureUploadServiceModel.class);

        PictureEntity pictureEntity = createPictureEntity(pictureUploadServiceModel.getPicture());


        pictureEntity
                .setCreated(Instant.now())
                .setModified(Instant.now());
//        pictureEntity.setOfferEntity(offerEntity);

        pictureRepository.save(pictureEntity);

        OfferEntity offerEntity = offerRepository.getById(offerId);

                offerEntity.getPictures()
                .add(pictureEntity);

                offerEntity.setModified(Instant.now());

        offerRepository.save(offerEntity);

    }

    private PictureEntity createPictureEntity (MultipartFile file) throws IOException {
        CloudinaryImage upload = cloudinaryService.upload(file);

        return new PictureEntity()
                .setPublicId(upload.getPublicId())
                .setUrl(upload.getUrl());
    }
}
