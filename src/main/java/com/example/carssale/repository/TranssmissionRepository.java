package com.example.carssale.repository;

import com.example.carssale.model.entity.TranssmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranssmissionRepository extends JpaRepository<TranssmissionEntity,Long> {
}
