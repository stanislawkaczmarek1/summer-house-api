package com.cottages.backend.infrastructure.repository;

import com.cottages.backend.infrastructure.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservationJpaRepository extends JpaRepository<ReservationEntity, Long> {

    List<ReservationEntity> findByCottageId(Long cottageId);

    List<ReservationEntity> findByClientId(Long clientId);

    @Query("""
            SELECT COUNT(r) > 0 FROM ReservationEntity r
            WHERE r.cottage.id = :cottageId
            AND r.status != com.cottages.backend.infrastructure.entity.ReservationEntity$Status.CANCELLED
            AND r.startDate < :endDate
            AND r.endDate > :startDate
            """)
    boolean existsOverlappingReservation(
            @Param("cottageId") Long cottageId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
