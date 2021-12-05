package com.example.carssale.service.Impl;

import com.example.carssale.model.dto.RegionDTO;
import com.example.carssale.model.entity.RegionEntity;
import com.example.carssale.repository.RegionRepository;
import com.example.carssale.service.RegionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;
    private final ModelMapper modelMapper;

    public RegionServiceImpl(RegionRepository regionRepository, ModelMapper modelMapper) {
        this.regionRepository = regionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RegionDTO> getAllRegions() {
        return regionRepository
                .findAll()
                .stream()
                .map(this::asRegion)
                .collect(Collectors.toList());
    }

    private RegionDTO asRegion(RegionEntity region) {

        return modelMapper.map(region,RegionDTO.class);
    }
}
