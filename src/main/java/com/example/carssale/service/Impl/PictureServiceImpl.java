package com.example.carssale.service.Impl;

import com.example.carssale.repository.PictureRepository;
import com.example.carssale.service.PictureService;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public void deleteByPicturePublicId(String publicID) {
        pictureRepository.deleteAllByPublicId(publicID);
    }
}
