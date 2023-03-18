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

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();

        return categoryList.stream().map(CategoryMapper::mapToDto).collect(Collectors.toList());
    }
}
