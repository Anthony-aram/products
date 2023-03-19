package com.products.products.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private int id;
    @NotEmpty(message = "Title should not be null or empty")
    @Size(min = 3, max = 50, message = "Le titre doit être entre 3 et 50 caractères")
    private String title;
    @NotEmpty(message = "Description should not be null or empty")
    @Size(min = 10, max = 1000)
    private String description;
    @NotNull
    private Float price;
    private Integer discount_percentage;
    @Min(0) @Max(5)
    private Float rating;
    private Integer stock;
    private String thumbnail;
    private Set<String> images;
    @NotNull
    private Integer category_id;
    private CategoryDto category;
    @NotNull
    private Integer brand_id;
    private BrandDto brand;
}
