package com.example.carssale.repository;

import com.example.carssale.model.entity.FuelTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelTypeRepository extends JpaRepository<FuelTypeEntity,Long> {
}
