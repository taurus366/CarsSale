package com.example.carssale.model.binding;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PictureUploadBindingModel {

    @NotEmpty
    private MultipartFile picture;

    public PictureUploadBindingModel() {
    }

    public MultipartFile getPicture() {
        return picture;
    }

    public PictureUploadBindingModel setPicture(MultipartFile picture) {
        this.picture = picture;
        return this;
    }
}
