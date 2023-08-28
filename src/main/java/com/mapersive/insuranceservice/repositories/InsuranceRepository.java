package com.mapersive.insuranceservice.repositories;

import com.mapersive.insuranceservice.entities.Insurance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

    @Query("select ins from Insurance ins")
    public Page<Insurance> getInsurancesByPagination(Pageable pageable);

}