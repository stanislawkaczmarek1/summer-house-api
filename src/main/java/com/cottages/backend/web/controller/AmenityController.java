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
    /*GET    /api/amenities                             # publiczne – lista udogodnień
      POST   /api/amenities                             # admin – dodanie udogodnienia
      POST   /api/amenities/bulk                        # admin – dodanie wielu udogodnień naraz
      PATCH  /api/amenities/{id}                        # admin – edycja udogodnienia
      DELETE /api/amenities/{id}                        # admin – usunięcie udogodnienia*/
    private final AmenityService amenityService;
    public AmenityController(AmenityService amenityService){this.amenityService = amenityService;}
    @PostMapping("/api/amenities/bulk")
    public void addAmenitiesBulk(@RequestBody List<String> names) {
        amenityService.addAmenitiesBulk(names);
    }
}
