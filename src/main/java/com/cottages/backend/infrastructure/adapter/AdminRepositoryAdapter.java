package com.cottages.backend.infrastructure.adapter;

import com.cottages.backend.domain.model.Admin;
import com.cottages.backend.domain.repository.AdminRepository;
import com.cottages.backend.infrastructure.entity.AdminEntity;
import com.cottages.backend.infrastructure.repository.AdminJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
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
    @Override
    public Admin save(Admin admin){
        AdminEntity entity = toEntity(admin);
        AdminEntity saved = jpaRepository.save(entity);
        return toModel(saved);
    }
    @Override
    public List<Admin> findAll(){
        return jpaRepository.findAll()
                .stream()
                .map(this::toModel)
                .toList();
    }
    @Override
    public void delete(Long id) {
        if (!jpaRepository.existsById(id)) {
            throw new RuntimeException("Admin not found");
        }
        jpaRepository.deleteById(id);
    }
    private Admin toModel(AdminEntity entity) {
        return new Admin(
                entity.getId(),
                entity.getLogin(),
                entity.getPasswordHash(),
                entity.getCreatedAt()
        );
    }
    private AdminEntity toEntity(Admin admin) {
        return new AdminEntity(
                admin.getId(),
                admin.getLogin(),
                admin.getPasswordHash(),
                admin.getCreatedAt()
        );
    }
}
