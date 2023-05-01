package com.products.products.service.impl;

import com.products.products.dto.CategoryDto;
import com.products.products.entity.Category;
import com.products.products.mapper.CategoryMapper;
import com.products.products.repository.CategoryRepository;
import com.products.products.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service pour les catégories
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();

        return categoryList.stream().map(categoryMapper::mapToDto).collect(Collectors.toList());
    }
}
