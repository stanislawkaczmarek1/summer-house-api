package com.cottages.backend.infrastructure.repository;

import com.cottages.backend.infrastructure.entity.AmenityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmenityJpaRepository extends JpaRepository<AmenityEntity, Long> {

    List<AmenityEntity> findAllByIdIn(List<Long> ids);
}
