package com.cottages.backend.application.service;

import com.cottages.backend.application.exception.CottageNotFoundException;
import com.cottages.backend.domain.model.Admin;
import com.cottages.backend.domain.model.Cottage;
import com.cottages.backend.domain.model.Reservation;
import com.cottages.backend.domain.repository.CottageRepository;
import com.cottages.backend.domain.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CottageService {
    private final CottageRepository cottageRepo;
    private final ReservationRepository reservationRepo;
    public CottageService(CottageRepository cottageRepo, ReservationRepository reservationRepo){
        this.cottageRepo = cottageRepo;
        this.reservationRepo = reservationRepo;
    }

    public List<Cottage> getAll() {
        return cottageRepo.findAllVisible();
    }
    public Cottage getCottageById(Long id){

        return cottageRepo.findById(id).orElseThrow(() -> new CottageNotFoundException(id));
    }
    public boolean isAvailable(
            Long cottageId,
            LocalDate startDate,
            LocalDate endDate) {

        List<Reservation> reservations =
                reservationRepo.findByCottageId(cottageId);

        return reservations.stream()
                .filter(r -> r.getStatus() != Reservation.Status.CANCELLED)
                .noneMatch(r ->
                        startDate.isBefore(r.getEndDate())
                                && endDate.isAfter(r.getStartDate()));
    }
    public Cottage save(Cottage cottage){
        return cottageRepo.save(cottage);
    }
    public Cottage update(Long id, Cottage updated) {

        Cottage existing = cottageRepo.findById(id)
                .orElseThrow(() -> new CottageNotFoundException(id));

        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        existing.setPricePerNight(updated.getPricePerNight());
        existing.setVisible(updated.getVisible());

        return cottageRepo.save(existing);
    }
    public Cottage updateVisibility(Long id, Boolean visible) {

        Cottage cottage = cottageRepo.findById(id)
                .orElseThrow(() -> new CottageNotFoundException(id));

        cottage.setVisible(visible);

        return cottageRepo.save(cottage);
    }
    public void delete(Long id){
        cottageRepo.deleteById(id);
    }
}
