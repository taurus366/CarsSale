package com.example.carssale.repository;

import com.example.carssale.model.entity.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByFirstName(String email);

//    @EntityGraph(value = "user-roles")
//    @Query("SELECT u FROM UserEntity u")
//    List<UserEntity> getAllUsersByEntityGraph();

}
