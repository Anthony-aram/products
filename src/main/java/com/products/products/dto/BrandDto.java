package com.products.products.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO représentant une marque
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandDto {

    /**
     * Identifiant de la marque
     */
    private int id;

    /**
     * Nom de la marque
     */
    @NotEmpty(message = "Name should not be null or empty")
    @Size(min = 3, max = 30)
    private String name;
}
