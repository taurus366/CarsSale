package com.example.carssale.repository;

import com.example.carssale.model.dto.BrandDTO;
import com.example.carssale.model.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity,Long> {

    BrandEntity findByBrandName(String brandName);
    List<BrandEntity> findAllByCategory_Id(Long category_id);
}
