package com.example.carssale.repository;

import com.example.carssale.model.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity,Long> {

    List<ModelEntity> findAllByBrand_Id(Long brand_id);
}
