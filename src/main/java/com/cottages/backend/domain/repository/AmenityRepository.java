package com.cottages.backend.domain.repository;

import com.cottages.backend.domain.model.Amenity;

import java.util.List;
import java.util.Optional;

public interface AmenityRepository {

    List<Amenity> findAll();

    Optional<Amenity> findById(Long id);

    List<Amenity> findAllByIds(List<Long> ids);

    Amenity save(Amenity amenity);

    void deleteById(Long id);
}
