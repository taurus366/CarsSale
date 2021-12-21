package com.example.carssale.repository;

import com.example.carssale.model.entity.CityVillageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityVillageRepository extends JpaRepository<CityVillageEntity,Long> {

//    @Query(value = "SELECT c FROM CityVillageEntity c WHERE c.region.id = :id")
//    List<CityVillageEntity> getAllCityVillageByRegionId(Long id);
    List<CityVillageEntity> getAllCityVillageByRegionId(Long id);
}
