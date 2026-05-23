package com.cottages.backend.domain.model;

public class CottageImage {

    private Long id;
    private Long cottageId;
    private String imageUrl;
    private Integer sortOrder;

    public CottageImage() {}

    public CottageImage(Long id, Long cottageId, String imageUrl, Integer sortOrder) {
        this.id = id;
        this.cottageId = cottageId;
        this.imageUrl = imageUrl;
        this.sortOrder = sortOrder;
    }

    public Long getId() { return id; }
    public Long getCottageId() { return cottageId; }
    public String getImageUrl() { return imageUrl; }
    public Integer getSortOrder() { return sortOrder; }

    public void setId(Long id) { this.id = id; }
    public void setCottageId(Long cottageId) { this.cottageId = cottageId; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setSortOrder(Integer sortOrder) { this.sortOrder = sortOrder; }
}
