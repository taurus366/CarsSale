package com.example.carssale.repository;

import com.example.carssale.model.entity.CarStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarStatusRepository extends JpaRepository<CarStatusEntity,Long> {
}
