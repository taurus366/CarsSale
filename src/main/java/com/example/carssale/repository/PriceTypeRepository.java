package com.example.carssale.repository;

import com.example.carssale.model.entity.PriceTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceTypeRepository extends JpaRepository<PriceTypeEntity,Long> {
}
