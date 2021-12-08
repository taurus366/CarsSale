package com.example.carssale.service.Impl;

import com.example.carssale.model.dto.BrandDTO;
import com.example.carssale.model.dto.ModelDTO;
import com.example.carssale.model.entity.BrandEntity;
import com.example.carssale.repository.BrandRepository;
import com.example.carssale.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandDTO> getBrandByCategoryId(Long id) {

        return  brandRepository.findAllByCategory_Id(id)
                .stream()
                .map(this::asBrandDTO)
                .collect(Collectors.toList());
    }

    private BrandDTO asBrandDTO(BrandEntity brand) {

      return  modelMapper.map(brand, BrandDTO.class);
    }
}
