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

/**
 * Entité représentant un produit
 */
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

    /**
     * Identifiant du produit
     */
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;

    /**
     * Titre du produit
     */
    @Column(nullable = false)
    @Size(min = 3, max = 50, message = "Le titre doit être entre 3 et 50 caractères")
    private String title;

    /**
     * Description du produit
     */
    @Column(nullable = false)
    @Size(min = 10, max = 1000)
    private String description;

    /**
     * Prix du produit
     */
    @Column(nullable = false)
    private Float price;

    /**
     * Pourcentage de réduction du produit
     */
    private Integer discountPercentage;

    /**
     * Note du produit
     */
    @Min(0) @Max(5)
    private Float rating;

    /**
     * Stock du produit
     */
    @Column(nullable = false)
    private Integer stock;

    /**
     * Image de présentation du produit
     */
    private String thumbnail;

    /**
     * Images du produit
     */
    @ElementCollection
    private Set<String> images;

    /**
     * Date de création du produit
     */
    @CreationTimestamp
    private LocalDateTime dateCreated;

    /**
     * Date de dernière mise à jour du produit
     */
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    /**
     * Catégorie du produit
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",
            foreignKey = @ForeignKey(name = "FK_Categories_Products"),
            referencedColumnName = "id",
            nullable = false)
    private Category category;

    /**
     * Marque du produit
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id",
            foreignKey = @ForeignKey(name = "FK_Brands_Products"),
            referencedColumnName = "id",
            nullable = false)
    private Brand brand;
}