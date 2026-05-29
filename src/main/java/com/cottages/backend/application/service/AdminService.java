package com.cottages.backend.application.service;

import com.cottages.backend.domain.model.Admin;
import com.cottages.backend.domain.repository.AdminRepository;
import com.cottages.backend.infrastructure.entity.AdminEntity;
import com.cottages.backend.infrastructure.repository.AdminJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminJpaRepository adminRepo;
    public AdminService(AdminJpaRepository adminRepo){this.adminRepo = adminRepo;}
    public List<AdminEntity> getAll() {
        return adminRepo.findAll();
    }
    public AdminEntity save(AdminEntity admin) {
        return adminRepo.save(admin);
    }
}
