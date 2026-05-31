package com.cottages.backend.application.service;

import com.cottages.backend.application.exception.AmenityNotFoundException;
import com.cottages.backend.application.exception.CottageNotFoundException;
import com.cottages.backend.domain.model.Amenity;
import com.cottages.backend.domain.model.Cottage;
import com.cottages.backend.domain.model.CottageImage;
import com.cottages.backend.domain.repository.AmenityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmenityService {


    private final AmenityRepository amRepo;

    public  AmenityService(AmenityRepository amRepo){this.amRepo = amRepo;}

    public List<Amenity> getAll(){
        return amRepo.findAll();
    }
    public Amenity save(Amenity amenity){
        return amRepo.save(amenity);
    }
    public void addAmenitiesBulk(List<String> names) {

        List<Amenity> amenities = new ArrayList<>();

        for (String name : names) {
            amenities.add(new Amenity(null, name));
        }

        amRepo.saveAll(amenities);
    }
    public Amenity update(Long id, Amenity updated){
        Amenity existing = amRepo.findById(id).orElseThrow(() -> new AmenityNotFoundException(id));

        existing.setName(updated.getName());
        return amRepo.save(existing);
    }
    public void delete(Long id){
        amRepo.deleteById(id);
    }
}
