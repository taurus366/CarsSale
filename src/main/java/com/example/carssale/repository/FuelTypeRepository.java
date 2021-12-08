package com.example.carssale.repository;

import com.example.carssale.model.entity.FuelTypeEntity;
import com.example.carssale.model.entity.enums.FuelTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelTypeRepository extends JpaRepository<FuelTypeEntity,Long> {

    FuelTypeEntity findByName(FuelTypeEnum name);
}
