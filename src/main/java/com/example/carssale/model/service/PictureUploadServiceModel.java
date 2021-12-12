package com.example.carssale.model.service;

import org.springframework.web.multipart.MultipartFile;

public class PictureUploadServiceModel {
    private MultipartFile picture;

    public PictureUploadServiceModel() {
    }

    public MultipartFile getPicture() {
        return picture;
    }

    public PictureUploadServiceModel setPicture(MultipartFile picture) {
        this.picture = picture;
        return this;
    }
}
