package com.cottages.backend.infrastructure.repository;

import com.cottages.backend.infrastructure.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminJpaRepository extends JpaRepository<AdminEntity, Long> {

    Optional<AdminEntity> findByLogin(String login);

    boolean existsByLogin(String login);
}
