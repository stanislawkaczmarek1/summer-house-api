package com.cottages.backend.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Cottage {

    private Long id;
    private String name;
    private String description;
    private Integer capacity;
    private BigDecimal pricePerNight;
    private String address;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Boolean isVisible;
    private LocalDateTime createdAt;
    private List<CottageImage> images;
    private List<Amenity> amenities;

    public Cottage() {}

    public Cottage(Long id, String name, String description, Integer capacity,
                   BigDecimal pricePerNight, String address, BigDecimal latitude,
                   BigDecimal longitude, Boolean isVisible, LocalDateTime createdAt,
                   List<CottageImage> images, List<Amenity> amenities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isVisible = isVisible;
        this.createdAt = createdAt;
        this.images = images;
        this.amenities = amenities;
    }

    public String getMainImageUrl() {
        if (images == null || images.isEmpty()) return null;
        return images.get(0).getImageUrl();
    }

    public boolean isAvailable() {
        return Boolean.TRUE.equals(isVisible);
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Integer getCapacity() { return capacity; }
    public BigDecimal getPricePerNight() { return pricePerNight; }
    public String getAddress() { return address; }
    public BigDecimal getLatitude() { return latitude; }
    public BigDecimal getLongitude() { return longitude; }
    public Boolean getIsVisible() { return isVisible; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public List<CottageImage> getImages() { return images; }
    public List<Amenity> getAmenities() { return amenities; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    public void setPricePerNight(BigDecimal pricePerNight) { this.pricePerNight = pricePerNight; }
    public void setAddress(String address) { this.address = address; }
    public void setLatitude(BigDecimal latitude) { this.latitude = latitude; }
    public void setLongitude(BigDecimal longitude) { this.longitude = longitude; }
    public void setIsVisible(Boolean isVisible) { this.isVisible = isVisible; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setImages(List<CottageImage> images) { this.images = images; }
    public void setAmenities(List<Amenity> amenities) { this.amenities = amenities; }
}
