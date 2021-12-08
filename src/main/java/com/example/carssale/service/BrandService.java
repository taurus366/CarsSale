package com.example.carssale.service;

import com.example.carssale.model.dto.BrandDTO;

import java.util.List;

public interface BrandService {

    List<BrandDTO> getBrandByCategoryId(Long id);
}
