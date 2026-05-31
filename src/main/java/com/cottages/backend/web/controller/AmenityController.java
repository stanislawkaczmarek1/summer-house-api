package com.cottages.backend.web.controller;

import com.cottages.backend.application.service.AmenityService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class AmenityController {
    private final AmenityService amenityService;
    public AmenityController(AmenityService amenityService){this.amenityService = amenityService;}
    @PostMapping("/api/amenities/bulk")
    public void addAmenitiesBulk(@RequestBody List<String> names) {
        amenityService.addAmenitiesBulk(names);
    }
}
