package com.cottages.backend.infrastructure.adapter;

import com.cottages.backend.domain.model.Amenity;
import com.cottages.backend.domain.model.Cottage;
import com.cottages.backend.domain.model.CottageImage;
import com.cottages.backend.domain.repository.CottageRepository;
import com.cottages.backend.infrastructure.entity.AmenityEntity;
import com.cottages.backend.infrastructure.entity.CottageEntity;
import com.cottages.backend.infrastructure.entity.CottageImageEntity;
import com.cottages.backend.infrastructure.repository.CottageJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CottageRepositoryAdapter implements CottageRepository {

    private final CottageJpaRepository jpaRepository;

    @Override
    public List<Cottage> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toModel)
                .toList();
    }

    @Override
    public List<Cottage> findAllVisible() {
        return jpaRepository.findAllByIsVisibleTrue().stream()
                .map(this::toModel)
                .toList();
    }

    @Override
    public Optional<Cottage> findById(Long id) {
        return jpaRepository.findById(id).map(this::toModel);
    }

    @Override
    public Cottage save(Cottage cottage) {
        CottageEntity entity = toEntity(cottage);
        return toModel(jpaRepository.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    private Cottage toModel(CottageEntity entity) {
        List<CottageImage> images = entity.getImages() == null ? Collections.emptyList() :
                entity.getImages().stream().map(this::toImageModel).toList();

        List<Amenity> amenities = entity.getAmenities() == null ? Collections.emptyList() :
                entity.getAmenities().stream().map(this::toAmenityModel).toList();

        return new Cottage(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getCapacity(),
                entity.getPricePerNight(),
                entity.getAddress(),
                entity.getLatitude(),
                entity.getLongitude(),
                entity.getIsVisible(),
                entity.getCreatedAt(),
                images,
                amenities
        );
    }

    private CottageEntity toEntity(Cottage model) {
        CottageEntity entity = new CottageEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity.setCapacity(model.getCapacity());
        entity.setPricePerNight(model.getPricePerNight());
        entity.setAddress(model.getAddress());
        entity.setLatitude(model.getLatitude());
        entity.setLongitude(model.getLongitude());
        entity.setIsVisible(model.getIsVisible());
        entity.setCreatedAt(model.getCreatedAt());
        return entity;
    }

    private CottageImage toImageModel(CottageImageEntity entity) {
        return new CottageImage(
                entity.getId(),
                entity.getCottage().getId(),
                entity.getImageUrl(),
                entity.getSortOrder()
        );
    }

    private Amenity toAmenityModel(AmenityEntity entity) {
        return new Amenity(entity.getId(), entity.getName());
    }
}
