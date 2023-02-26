package com.products.products.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class ProductDto {
    private int id;
    @NotEmpty(message = "Title should not be null or empty")
    @Size(min = 3, max = 30, message = "Le titre doit être entre 3 et 30 caractères")
    private String title;
    @NotEmpty(message = "Description should not be null or empty")
    @Size(min = 10, max = 1000)
    private String description;
    @NotNull
    private Float price;
    private Float discountPercentage;
    @Min(0) @Max(5)
    private Float rating;
    private Integer stock;
    private Set<String> images;
}
