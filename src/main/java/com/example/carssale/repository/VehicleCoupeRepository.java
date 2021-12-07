package com.example.carssale.repository;

import com.example.carssale.model.entity.VehicleCoupeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleCoupeRepository extends JpaRepository<VehicleCoupeEntity,Long> {
}
