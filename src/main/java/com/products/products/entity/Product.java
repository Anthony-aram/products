package com.products.products.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        name = "Products",
        uniqueConstraints = { @UniqueConstraint(name = "UQ_Products_Title", columnNames = { "title" }) }
)
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @Column(nullable = false)
    @Size(min = 3, max = 30, message = "Le titre doit être entre 3 et 30 caractères")
    private String title;
    @Column(nullable = false)
    @Size(min = 10, max = 1000)
    private String description;
    @Column(nullable = false)
    private Float price;
    private Float discountPercentage = 0F;
    @Min(0) @Max(5)
    private Float rating;
    @Column(nullable = false)
    private Integer stock = 0;
    private Set<String> images;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",
            foreignKey = @ForeignKey(name = "FK_Categories_Products"),
            referencedColumnName = "id",
            nullable = false)
    private Category category;
}