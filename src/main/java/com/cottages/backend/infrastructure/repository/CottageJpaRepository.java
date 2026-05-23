package com.cottages.backend.infrastructure.repository;

import com.cottages.backend.infrastructure.entity.CottageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CottageJpaRepository extends JpaRepository<CottageEntity, Long> {

    List<CottageEntity> findAllByIsVisibleTrue();
}
