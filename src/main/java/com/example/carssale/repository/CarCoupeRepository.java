package com.example.carssale.repository;

import com.example.carssale.model.entity.CarCoupeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarCoupeRepository extends JpaRepository<CarCoupeEntity,Long> {
}
