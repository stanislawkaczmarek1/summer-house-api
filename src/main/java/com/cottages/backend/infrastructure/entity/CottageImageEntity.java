package com.cottages.backend.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "cottage_images",
        uniqueConstraints = @UniqueConstraint(columnNames = {"cottage_id", "sort_order"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CottageImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cottage_id", nullable = false)
    private CottageEntity cottage;

    @Column(name = "image_url", nullable = false, length = 255)
    private String imageUrl;

    @Column(name = "sort_order", nullable = false)
    private Integer sortOrder;
}