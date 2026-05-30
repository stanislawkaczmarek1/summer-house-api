package com.cottages.backend.domain.repository;

import com.cottages.backend.domain.model.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository {

    List<Reservation> findAll();

    List<Reservation> findByCottageId(Long cottageId);

    List<Reservation> findByClientId(Long clientId);

    Optional<Reservation> findById(Long id);

    Reservation save(Reservation reservation);
    void deleteById(Long id);

    boolean existsOverlappingReservation(Long cottageId, LocalDate startDate, LocalDate endDate);
}
