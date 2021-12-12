package com.example.carssale.service;

import com.example.carssale.model.binding.PictureUploadBindingModel;

import java.io.IOException;

public interface PictureService {

    void deleteByPicturePublicId(String publicID);

    void uploadPicture(PictureUploadBindingModel pictureUploadBindingModel, Long offerId) throws IOException;
}
