package com.cottages.backend.domain.repository;

import com.cottages.backend.domain.model.Cottage;

import java.util.List;
import java.util.Optional;

public interface CottageRepository {

    List<Cottage> findAll();

    List<Cottage> findAllVisible();

    Optional<Cottage> findById(Long id);

    Cottage save(Cottage cottage);

    void deleteById(Long id);

    boolean existsById(Long id);
}
