package com.cottages.backend.infrastructure.adapter;

import com.cottages.backend.domain.model.Client;
import com.cottages.backend.domain.model.Reservation;
import com.cottages.backend.domain.repository.ReservationRepository;
import com.cottages.backend.infrastructure.entity.ClientEntity;
import com.cottages.backend.infrastructure.entity.CottageEntity;
import com.cottages.backend.infrastructure.entity.ReservationEntity;
import com.cottages.backend.infrastructure.repository.ReservationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReservationRepositoryAdapter implements ReservationRepository {

    private final ReservationJpaRepository jpaRepository;

    @Override
    public List<Reservation> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toModel)
                .toList();
    }

    @Override
    public List<Reservation> findByCottageId(Long cottageId) {
        return jpaRepository.findByCottageId(cottageId).stream()
                .map(this::toModel)
                .toList();
    }

    @Override
    public List<Reservation> findByClientId(Long clientId) {
        return jpaRepository.findByClientId(clientId).stream()
                .map(this::toModel)
                .toList();
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return jpaRepository.findById(id).map(this::toModel);
    }

    @Override
    public Reservation save(Reservation reservation) {
        ReservationEntity entity = toEntity(reservation);
        return toModel(jpaRepository.save(entity));
    }

    @Override
    public boolean existsOverlappingReservation(Long cottageId, LocalDate startDate, LocalDate endDate) {
        return jpaRepository.existsOverlappingReservation(cottageId, startDate, endDate);
    }

    private Reservation toModel(ReservationEntity entity) {
        ClientEntity c = entity.getClient();
        Client client = new Client(
                c.getId(),
                c.getFirstName(),
                c.getLastName(),
                c.getEmail(),
                c.getPhone(),
                c.getCreatedAt()
        );

        return new Reservation(
                entity.getId(),
                entity.getCottage().getId(),
                client,
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getGuestsCount(),
                entity.getTotalPrice(),
                Reservation.Status.valueOf(entity.getStatus().name()),
                entity.getCreatedAt(),
                entity.getCancelledAt()
        );
    }

    private ReservationEntity toEntity(Reservation model) {
        ReservationEntity entity = new ReservationEntity();
        entity.setId(model.getId());

        CottageEntity cottage = new CottageEntity();
        cottage.setId(model.getCottageId());
        entity.setCottage(cottage);

        ClientEntity client = new ClientEntity();
        client.setId(model.getClient().getId());
        entity.setClient(client);

        entity.setStartDate(model.getStartDate());
        entity.setEndDate(model.getEndDate());
        entity.setGuestsCount(model.getGuestsCount());
        entity.setTotalPrice(model.getTotalPrice());
        entity.setStatus(ReservationEntity.Status.valueOf(model.getStatus().name()));
        entity.setCreatedAt(model.getCreatedAt());
        entity.setCancelledAt(model.getCancelledAt());
        return entity;
    }
}
