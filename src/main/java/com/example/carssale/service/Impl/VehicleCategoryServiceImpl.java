package com.example.carssale.service.Impl;

import com.example.carssale.model.dto.VehicleCategoryDTO;
import com.example.carssale.model.entity.VehicleCategoryEntity;
import com.example.carssale.repository.VehicleCategoryRepository;
import com.example.carssale.service.VehicleCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleCategoryServiceImpl implements VehicleCategoryService {

    private final VehicleCategoryRepository vehicleCategoryRepository;
    private final ModelMapper modelMapper;

    public VehicleCategoryServiceImpl(VehicleCategoryRepository vehicleCategoryRepository, ModelMapper modelMapper) {
        this.vehicleCategoryRepository = vehicleCategoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<VehicleCategoryDTO> getAllVehicleCategories() {


      return   vehicleCategoryRepository.findAll()
                .stream()
                .map(this::asCategoryDTO)
                .collect(Collectors.toList());
    }

    private VehicleCategoryDTO asCategoryDTO(VehicleCategoryEntity vehicle) {

       return modelMapper.map(vehicle,VehicleCategoryDTO.class);
    }
}
