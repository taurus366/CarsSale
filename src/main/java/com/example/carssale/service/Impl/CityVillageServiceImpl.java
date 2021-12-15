package com.example.carssale.service.Impl;

import com.example.carssale.model.dto.CityVillageDTO;
import com.example.carssale.model.entity.CityVillageEntity;
import com.example.carssale.repository.CityVillageRepository;
import com.example.carssale.service.CityVillageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityVillageServiceImpl implements CityVillageService {

    private final CityVillageRepository cityVillageRepository;
    private final ModelMapper modelMapper;

    public CityVillageServiceImpl(CityVillageRepository cityVillageRepository, ModelMapper modelMapper) {
        this.cityVillageRepository = cityVillageRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<CityVillageDTO> getCityVillageById(Long id) {
        return cityVillageRepository
                .getAllCityVillageByRegionId(id)
                .stream()
                .map(this::asCityVillageDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CityVillageDTO> getAllCities() {
      return  cityVillageRepository.findAll()
                .stream()
                .map(cityVillage -> modelMapper.map(cityVillage,CityVillageDTO.class))
                .collect(Collectors.toList());
    }

    private CityVillageDTO asCityVillageDTO(CityVillageEntity cityVillage) {
        return modelMapper.map(cityVillage,CityVillageDTO.class);
    }
}
