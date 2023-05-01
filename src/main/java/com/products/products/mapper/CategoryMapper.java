package com.products.products.mapper;

import com.products.products.dto.CategoryDto;
import com.products.products.entity.Category;
import org.springframework.stereotype.Service;

/**
 * Mapper pour les catégories
 */
@Service
public class CategoryMapper implements Mapper<Category, CategoryDto> {
    /**
     * Map a Category to a CategoryDto
     * @param category Category to map
     * @return CategoryDto
     */
    @Override
    public CategoryDto mapToDto(Category category) {
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
    @Override
    public Category mapToEntity(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .build();
    }
}
