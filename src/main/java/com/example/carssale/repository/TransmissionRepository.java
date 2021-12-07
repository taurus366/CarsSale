package com.example.carssale.repository;

import com.example.carssale.model.entity.TransmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransmissionRepository extends JpaRepository<TransmissionEntity,Long> {
}
