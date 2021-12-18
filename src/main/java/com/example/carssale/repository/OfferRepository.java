package com.example.carssale.repository;

import com.example.carssale.model.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity,Long> {

    List<OfferEntity> findAllByUserEmail(String user_email);
}
