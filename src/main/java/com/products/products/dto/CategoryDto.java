package com.products.products.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO représentant une catégorie
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    /**
     * Identifiant de la catégorie
     */
    private int id;

    /**
     * Nom de la catégorie
     */
    @NotEmpty(message = "Name should not be null or empty")
    @Size(min = 3, max = 30)
    private String name;
}