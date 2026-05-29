package com.cottages.backend.domain.repository;

import com.cottages.backend.domain.model.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminRepository {

    Optional<Admin> findByLogin(String login);

    boolean existsByLogin(String login);
    Admin save(Admin admin);
    List<Admin> findAll();
    void delete(Long id);

}
