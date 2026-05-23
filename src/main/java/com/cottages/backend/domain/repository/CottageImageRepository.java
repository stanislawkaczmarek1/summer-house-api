package com.cottages.backend.domain.repository;

import com.cottages.backend.domain.model.CottageImage;

import java.util.List;
import java.util.Optional;

public interface CottageImageRepository {

    List<CottageImage> findByCottageId(Long cottageId);

    Optional<CottageImage> findById(Long id);

    CottageImage save(CottageImage image);

    void deleteById(Long id);

    int countByCottageId(Long cottageId);
}
