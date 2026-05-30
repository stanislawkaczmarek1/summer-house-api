package com.cottages.backend.application.service;

import com.cottages.backend.domain.model.Admin;
import com.cottages.backend.domain.model.Client;
import com.cottages.backend.domain.repository.AdminRepository;
import com.cottages.backend.domain.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepo;
    public ClientService(ClientRepository clientRepo){this.clientRepo = clientRepo;}
    public List<Client> getAll() {
        return clientRepo.findAll();
    }
    public Client save(Client client) {
        return clientRepo.save(client);
    }

    public void delete(Long id){
        clientRepo.delete(id);
    }
}
