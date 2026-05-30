package com.cottages.backend.application.service;

import com.cottages.backend.domain.repository.CottageImageRepository;
import org.springframework.stereotype.Service;

@Service
public class CottageImageService {
    private final CottageImageRepository imRepo;

    public CottageImageService(CottageImageRepository imRepo){this.imRepo = imRepo;}


}
