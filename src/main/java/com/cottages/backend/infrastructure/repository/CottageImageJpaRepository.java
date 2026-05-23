package com.cottages.backend.infrastructure.repository;

import com.cottages.backend.infrastructure.entity.CottageImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CottageImageJpaRepository extends JpaRepository<CottageImageEntity, Long> {

    List<CottageImageEntity> findByCottageIdOrderBySortOrderAsc(Long cottageId);

    int countByCottageId(Long cottageId);
}
