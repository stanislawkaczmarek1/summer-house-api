package com.cottages.backend.web.controller;

import com.cottages.backend.application.service.ReservationService;
import com.cottages.backend.domain.model.Reservation;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ReservationController {
    /*POST   /api/reservations                          # publiczne – utworzenie rezerwacji
   GET    /api/reservations                          # admin – lista rezerwacji
   GET    /api/reservations/{id}                     # admin – szczegóły rezerwacji
   DELETE /api/reservations/{id}                     # admin – usunięcie rezerwacji*/
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
}
