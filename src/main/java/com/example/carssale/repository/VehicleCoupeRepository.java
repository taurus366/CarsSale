package com.example.carssale.repository;

import com.example.carssale.model.entity.VehicleCoupeEntity;
import com.example.carssale.model.entity.VehicleYearEntity;
import com.example.carssale.model.entity.enums.VehicleCoupeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleCoupeRepository extends JpaRepository<VehicleCoupeEntity,Long> {

    VehicleCoupeEntity findByVehicleCoupe(VehicleCoupeEnum vehicleCoupe);
}
