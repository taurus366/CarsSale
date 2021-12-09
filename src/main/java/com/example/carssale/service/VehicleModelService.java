package com.example.carssale.service;

import com.example.carssale.model.dto.ModelDTO;

import java.util.List;

public interface VehicleModelService {

    List<ModelDTO> getVehicleModelByBrandId(Long id);
}
