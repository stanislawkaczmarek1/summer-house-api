package com.cottages.backend.application.service;

import com.cottages.backend.application.exception.ReservationNotFoundException;
import com.cottages.backend.domain.model.Reservation;
import com.cottages.backend.domain.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository resRepo;

    public ReservationService(ReservationRepository resRepo){this.resRepo = resRepo;}

    public Reservation save(Reservation reservation){
        return resRepo.save(reservation);
    }
    public List<Reservation> getAll(){
        return resRepo.findAll();
    }
    public Reservation getById(Long id){
        return resRepo.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));
    }

    public Reservation update(Long id, Reservation updated) {

        Reservation existing = resRepo.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));

        existing.setStartDate(updated.getStartDate());
        existing.setEndDate(updated.getEndDate());
        existing.setGuestsCount(updated.getGuestsCount());
        existing.setTotalPrice(updated.getTotalPrice());

        return resRepo.save(existing);
    }
    public void delete(Long id){
        resRepo.deleteById(id);
    }
    public Reservation cancelReservation(Long id) {

        Reservation reservation = resRepo.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));

        if (!reservation.isCancellable()) {
            throw new RuntimeException("Reservation cannot be cancelled");
        }

        reservation.setStatus(Reservation.Status.CANCELLED);
        reservation.setCancelledAt(LocalDateTime.now());
        return resRepo.save(reservation);
    }
}
