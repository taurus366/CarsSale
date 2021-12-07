package com.example.carssale.repository;

import com.example.carssale.model.entity.VehicleCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleCategoryRepository extends JpaRepository<VehicleCategoryEntity,Long> {
}
