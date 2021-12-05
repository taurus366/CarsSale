package com.example.carssale.service;

import com.example.carssale.model.dto.CityVillageDTO;
import com.example.carssale.model.dto.RegionDTO;

import java.util.List;

public interface CityVillageService {

    List<CityVillageDTO> getCityVillageById(Long id);
}
