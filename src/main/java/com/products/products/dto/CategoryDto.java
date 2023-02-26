package com.products.products.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private int id;
    @NotEmpty(message = "Name should not be null or empty")
    @Size(min = 3, max = 30)
    private String name;
}