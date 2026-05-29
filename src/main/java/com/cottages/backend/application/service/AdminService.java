package com.cottages.backend.application.service;

import com.cottages.backend.domain.model.Admin;
import com.cottages.backend.domain.repository.AdminRepository;
import com.cottages.backend.infrastructure.entity.AdminEntity;
import com.cottages.backend.infrastructure.repository.AdminJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepo;
    public AdminService(AdminRepository adminRepo){this.adminRepo = adminRepo;}
    public List<Admin> getAll() {
        return adminRepo.findAll();
    }
    public Admin save(Admin admin) {
        return adminRepo.save(admin);
    }

    public void delete(Long id){
        adminRepo.delete(id);
    }
}
