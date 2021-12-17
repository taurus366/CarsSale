package com.example.carssale.service;

import com.example.carssale.model.entity.FeatureEntity;
import com.example.carssale.model.service.FeatureServiceModel;

import java.util.List;

public interface FeatureService {

    FeatureServiceModel getFeatureByName(String name);
}
