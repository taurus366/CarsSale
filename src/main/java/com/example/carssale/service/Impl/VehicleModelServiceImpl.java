package com.example.carssale.service.Impl;

import com.example.carssale.model.dto.ModelDTO;
import com.example.carssale.model.entity.ModelEntity;
import com.example.carssale.repository.ModelRepository;
import com.example.carssale.service.VehicleModelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleModelServiceImpl implements VehicleModelService {

    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public VehicleModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ModelDTO> getVehicleModelByBrandId(Long id) {

     return    modelRepository.findAllByBrand_Id(id)
                .stream()
                .map(this::asModelDTO)
                .collect(Collectors.toList());
//                .map(modelEntity -> {
//                    ModelDTO model = new ModelDTO();
//                    model.setModelName(modelEntity.getModelName());
//                    model.setId(modelEntity.getId());
//                    model.setVehicleCoupe(modelEntity.getVehicleCoupe()
//                            .stream()
//                            .map(vehicleCoupeEntity -> ))
//                })
    }

    private ModelDTO asModelDTO(ModelEntity model) {

      return modelMapper.map(model,ModelDTO.class);


    }

}
