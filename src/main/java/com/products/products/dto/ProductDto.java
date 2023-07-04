package com.products.products.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * DTO représentant un produit
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    /**
     * Identifiant du produit
     */
    private int id;

    /**
     * Titre du produit
     */
    @NotEmpty(message = "Title should not be null or empty")
    @Size(min = 3, max = 50, message = "Le titre doit être entre 3 et 50 caractères")
    private String title;

    /**
     * Description du produit
     */
    @NotEmpty(message = "Description should not be null or empty")
    @Size(min = 10, max = 1000)
    private String description;

    /**
     * Prix du produit
     */
    @NotNull
    private Float price;

    /**
     * Pourcentage de réduction du produit
     */
    private Integer discount_percentage;

    /**
     * Note du produit
     */
    @Min(0) @Max(5)
    private Float rating;

    /**
     * Stock du produit
     */
    private Integer stock;

    /**
     * Image de présentation produit
     */
    private String thumbnail;

    /**
     * Images du produit
     */
    private Set<String> images;

    /**
     * Id de la catégorie du produit
     */
    @NotNull
    private Integer category_id;

    /**
     * Catégorie du produit
     */
    private CategoryDto category;

    /**
     * Id de la marque du produit
     */
    @NotNull
    private Integer brand_id;

    /**
     * Marque du produit
     */
    private BrandDto brand;
}
