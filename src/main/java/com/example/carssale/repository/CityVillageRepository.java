package com.example.carssale.repository;

import com.example.carssale.model.entity.CityVillageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityVillageRepository extends JpaRepository<CityVillageEntity,Long> {
}
