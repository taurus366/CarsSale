package com.example.carssale.repository;

import com.example.carssale.model.entity.RoleEntity;
import com.example.carssale.model.entity.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {

    RoleEntity findByRole(RoleEnum role);
}
