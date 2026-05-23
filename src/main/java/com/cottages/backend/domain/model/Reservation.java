package com.cottages.backend.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Reservation {

    public enum Status {
        PENDING, CONFIRMED, CANCELLED
    }

    private Long id;
    private Long cottageId;
    private Client client;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer guestsCount;
    private BigDecimal totalPrice;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime cancelledAt;

    public Reservation() {}

    public Reservation(Long id, Long cottageId, Client client, LocalDate startDate,
                       LocalDate endDate, Integer guestsCount, BigDecimal totalPrice,
                       Status status, LocalDateTime createdAt, LocalDateTime cancelledAt) {
        this.id = id;
        this.cottageId = cottageId;
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guestsCount = guestsCount;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdAt = createdAt;
        this.cancelledAt = cancelledAt;
    }

    public long getNightsCount() {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    public boolean isCancellable() {
        return status == Status.PENDING || status == Status.CONFIRMED;
    }

    public boolean isActive() {
        return status != Status.CANCELLED;
    }

    public Long getId() { return id; }
    public Long getCottageId() { return cottageId; }
    public Client getClient() { return client; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public Integer getGuestsCount() { return guestsCount; }
    public BigDecimal getTotalPrice() { return totalPrice; }
    public Status getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getCancelledAt() { return cancelledAt; }

    public void setId(Long id) { this.id = id; }
    public void setCottageId(Long cottageId) { this.cottageId = cottageId; }
    public void setClient(Client client) { this.client = client; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setGuestsCount(Integer guestsCount) { this.guestsCount = guestsCount; }
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }
    public void setStatus(Status status) { this.status = status; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setCancelledAt(LocalDateTime cancelledAt) { this.cancelledAt = cancelledAt; }
}
