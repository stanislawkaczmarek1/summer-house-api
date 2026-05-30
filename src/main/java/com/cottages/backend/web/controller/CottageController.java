package com.cottages.backend.web.controller;

import com.cottages.backend.application.exception.CottageNotFoundException;
import com.cottages.backend.application.service.CottageService;
import com.cottages.backend.domain.model.Cottage;
import com.cottages.backend.domain.repository.CottageRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CottageController {
    private final CottageService service;
    private final CottageRepository repo;

    public CottageController(CottageService service, CottageRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    @GetMapping("/api/cottages")
    public List<Cottage> getAllLoans() {
        return service.getAll();
    }

    @GetMapping("/api/cottages/{id}")
    public Cottage getCottageById(@PathVariable Long id) {

        return service.getCottageById(id);
    }

    @GetMapping("/api/cottages/{id}/availability")
    public boolean getAvailability(@PathVariable Long id, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return service.isAvailable(id, startDate, endDate);
    }

    @PostMapping("/api/cottages")
    public Cottage save(Cottage cottage) {
        return service.save(cottage);
    }

    @PutMapping("/api/cottages/{id}")
    public Cottage update(@PathVariable Long id, @RequestBody Cottage cottage) {
        return service.update(id, cottage);
    }

    @PatchMapping("/api/cottages/{id}")
    public Cottage updateVisibility(@PathVariable Long id, @RequestParam Boolean visible) {

        return service.updateVisibility(id, visible);
    }
    @DeleteMapping("/api/cottages/{id}")
    public void delete(Long id){
        service.delete(id);
    }

}
