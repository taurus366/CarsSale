package com.example.carssale.repository;

import com.example.carssale.model.entity.VehicleCategoryEntity;
import com.example.carssale.model.entity.enums.VehicleCategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleCategoryRepository extends JpaRepository<VehicleCategoryEntity,Long> {

    VehicleCategoryEntity findByVehicleCategoryName(VehicleCategoryEnum vehicleCategoryName);
}
