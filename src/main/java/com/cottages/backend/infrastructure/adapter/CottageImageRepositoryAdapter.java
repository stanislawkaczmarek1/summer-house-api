package com.cottages.backend.infrastructure.adapter;

import com.cottages.backend.domain.model.CottageImage;
import com.cottages.backend.domain.repository.CottageImageRepository;
import com.cottages.backend.infrastructure.entity.CottageEntity;
import com.cottages.backend.infrastructure.entity.CottageImageEntity;
import com.cottages.backend.infrastructure.repository.CottageImageJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CottageImageRepositoryAdapter implements CottageImageRepository {

    private final CottageImageJpaRepository jpaRepository;

    @Override
    public List<CottageImage> findByCottageId(Long cottageId) {
        return jpaRepository.findByCottageIdOrderBySortOrderAsc(cottageId).stream()
                .map(this::toModel)
                .toList();
    }

    @Override
    public Optional<CottageImage> findById(Long id) {
        return jpaRepository.findById(id).map(this::toModel);
    }

    @Override
    public CottageImage save(CottageImage image) {
        return toModel(jpaRepository.save(toEntity(image)));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public int countByCottageId(Long cottageId) {
        return jpaRepository.countByCottageId(cottageId);
    }

    private CottageImage toModel(CottageImageEntity entity) {
        return new CottageImage(
                entity.getId(),
                entity.getCottage().getId(),
                entity.getImageUrl(),
                entity.getSortOrder()
        );
    }

    private CottageImageEntity toEntity(CottageImage model) {
        CottageImageEntity entity = new CottageImageEntity();
        entity.setId(model.getId());
        entity.setImageUrl(model.getImageUrl());
        entity.setSortOrder(model.getSortOrder());

        CottageEntity cottage = new CottageEntity();
        cottage.setId(model.getCottageId());
        entity.setCottage(cottage);

        return entity;
    }
}
