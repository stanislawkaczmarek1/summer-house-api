package com.cottages.backend.web.controller;

import com.cottages.backend.application.service.AmenityService;
import com.cottages.backend.domain.model.Amenity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class AmenityController {
    private final AmenityService amenityService;
    public AmenityController(AmenityService amenityService){this.amenityService = amenityService;}
    @PostMapping("/api/amenities/bulk")
    public void addAmenitiesBulk(@RequestBody List<String> names) {
        amenityService.addAmenitiesBulk(names);
    }

    @GetMapping("/api/amenities")
    public List<Amenity> getAll(){
        return amenityService.getAll();
    }
    @PostMapping("/api/amenities")
    public Amenity save(Amenity amenity){
        return amenityService.save(amenity);
    }
    @PatchMapping("/api/amenities/{id}")
    public Amenity update(Long id, Amenity amenity){
        return amenityService.update(id, amenity);
    }
    @DeleteMapping("/api/amenities/{id}")
    public void delete(Long id){
        amenityService.delete(id);
    }
}
