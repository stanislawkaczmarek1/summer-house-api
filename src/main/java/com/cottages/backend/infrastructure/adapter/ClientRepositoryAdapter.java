package com.cottages.backend.infrastructure.adapter;

import com.cottages.backend.domain.model.Client;
import com.cottages.backend.domain.repository.ClientRepository;
import com.cottages.backend.infrastructure.entity.ClientEntity;
import com.cottages.backend.infrastructure.repository.ClientJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClientRepositoryAdapter implements ClientRepository {

    private final ClientJpaRepository jpaRepository;

    @Override
    public Optional<Client> findById(Long id) {
        return jpaRepository.findById(id).map(this::toModel);
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        return jpaRepository.findByEmail(email).map(this::toModel);
    }

    @Override
    public Client save(Client client) {
        return toModel(jpaRepository.save(toEntity(client)));
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }

    private Client toModel(ClientEntity entity) {
        return new Client(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getCreatedAt()
        );
    }

    private ClientEntity toEntity(Client model) {
        ClientEntity entity = new ClientEntity();
        entity.setId(model.getId());
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setEmail(model.getEmail());
        entity.setPhone(model.getPhone());
        entity.setCreatedAt(model.getCreatedAt());
        return entity;
    }
}
