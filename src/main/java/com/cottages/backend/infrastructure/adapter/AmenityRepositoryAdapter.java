package com.cottages.backend.infrastructure.adapter;

import com.cottages.backend.domain.model.Amenity;
import com.cottages.backend.domain.repository.AmenityRepository;
import com.cottages.backend.infrastructure.entity.AmenityEntity;
import com.cottages.backend.infrastructure.repository.AmenityJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AmenityRepositoryAdapter implements AmenityRepository {

    private final AmenityJpaRepository jpaRepository;

    @Override
    public List<Amenity> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toModel)
                .toList();
    }

    @Override
    public Optional<Amenity> findById(Long id) {
        return jpaRepository.findById(id).map(this::toModel);
    }

    @Override
    public List<Amenity> findAllByIds(List<Long> ids) {
        return jpaRepository.findAllByIdIn(ids).stream()
                .map(this::toModel)
                .toList();
    }

    @Override
    public Amenity save(Amenity amenity) {
        return toModel(jpaRepository.save(toEntity(amenity)));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    private Amenity toModel(AmenityEntity entity) {
        return new Amenity(entity.getId(), entity.getName());
    }

    private AmenityEntity toEntity(Amenity model) {
        AmenityEntity entity = new AmenityEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        return entity;
    }
}
