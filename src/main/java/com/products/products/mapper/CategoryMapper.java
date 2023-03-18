package com.products.products.mapper;

import com.products.products.dto.CategoryDto;
import com.products.products.entity.Category;

public class CategoryMapper {
    /**
     * Map a Category to a CategoryDto
     * @param category Category to map
     * @return CategoryDto
     */
    public static CategoryDto mapToDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    /**
     * Map a CategoryDto to a Category
     * @param categoryDto CategoryDto to map
     * @return Category
     */
    public static Category mapToEntity(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .build();
    }
}
