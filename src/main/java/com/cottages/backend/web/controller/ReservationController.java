package com.cottages.backend.web.controller;

import com.cottages.backend.application.service.ReservationService;
import com.cottages.backend.domain.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ReservationController {

    private final ReservationService resService;
    public ReservationController(ReservationService resService){this.resService = resService;}

    @PatchMapping("/api/reservations/{id}")
    public Reservation patchReservation(@PathVariable Long id,@RequestBody Reservation reservation) {
        return resService.update(id, reservation);
    }
    @PatchMapping("/api/reservations/{id}/cancel")
    public Reservation cancelReservation(@PathVariable Long id) {
        return resService.cancelReservation(id);
    }
    @PostMapping("/api/reservations")
    public Reservation save(Reservation reservation){
        return resService.save(reservation);
    }

    @GetMapping("/api/reservations")
    public List<Reservation> getAll(){
        return resService.getAll();
    }
    @GetMapping("/api/reservations/{id}")
    public Reservation getById(Long id){
        return resService.getById(id);
    }
    @DeleteMapping("/api/reservations/{id}")
    public void delete(Long id){
        resService.delete(id);
    }

}
