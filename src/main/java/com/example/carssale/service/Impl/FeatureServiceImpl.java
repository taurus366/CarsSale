package com.example.carssale.service.Impl;

import com.example.carssale.model.entity.FeatureEntity;
import com.example.carssale.model.service.FeatureServiceModel;
import com.example.carssale.repository.FeatureRepository;
import com.example.carssale.service.FeatureService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class FeatureServiceImpl implements FeatureService {


    private final FeatureRepository featureRepository;
    private final ModelMapper modelMapper;

    public FeatureServiceImpl(FeatureRepository featureRepository, ModelMapper modelMapper) {
        this.featureRepository = featureRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FeatureServiceModel getFeatureByName(String name) {

        FeatureEntity byName = featureRepository.findByName(name);

        return modelMapper.map(byName, FeatureServiceModel.class);
    }
}
