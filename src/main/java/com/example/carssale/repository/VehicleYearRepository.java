package com.example.carssale.repository;

import com.example.carssale.model.entity.VehicleYearEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleYearRepository extends JpaRepository<VehicleYearEntity,Long> {

    VehicleYearEntity findByVehicleYear(Integer vehicleYear);
}
