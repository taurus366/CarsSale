package com.example.carssale.repository;

import com.example.carssale.model.entity.FeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<FeatureEntity, Long> {


    FeatureEntity findByName(String name);
}
