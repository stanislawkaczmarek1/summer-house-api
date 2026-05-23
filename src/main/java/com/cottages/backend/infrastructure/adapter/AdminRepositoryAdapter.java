package com.cottages.backend.infrastructure.adapter;

import com.cottages.backend.domain.model.Admin;
import com.cottages.backend.domain.repository.AdminRepository;
import com.cottages.backend.infrastructure.entity.AdminEntity;
import com.cottages.backend.infrastructure.repository.AdminJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AdminRepositoryAdapter implements AdminRepository {

    private final AdminJpaRepository jpaRepository;

    @Override
    public Optional<Admin> findByLogin(String login) {
        return jpaRepository.findByLogin(login).map(this::toModel);
    }

    @Override
    public boolean existsByLogin(String login) {
        return jpaRepository.existsByLogin(login);
    }

    private Admin toModel(AdminEntity entity) {
        return new Admin(
                entity.getId(),
                entity.getLogin(),
                entity.getPasswordHash(),
                entity.getCreatedAt()
        );
    }
}
