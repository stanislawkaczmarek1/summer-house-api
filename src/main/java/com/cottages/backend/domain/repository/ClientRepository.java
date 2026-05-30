package com.cottages.backend.domain.repository;

import com.cottages.backend.domain.model.Admin;
import com.cottages.backend.domain.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    Optional<Client> findById(Long id);

    Optional<Client> findByEmail(String email);

    Client save(Client client);

    boolean existsByEmail(String email);
    List<Client> findAll();
    void delete(Long id);
}
