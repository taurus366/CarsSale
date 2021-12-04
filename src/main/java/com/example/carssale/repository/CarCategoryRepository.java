package com.example.carssale.repository;

import com.example.carssale.model.entity.CarCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarCategoryRepository extends JpaRepository<CarCategoryEntity,Long> {
}
