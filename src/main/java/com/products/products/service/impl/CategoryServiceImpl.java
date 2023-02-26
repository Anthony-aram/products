package com.products.products.service.impl;

import com.products.products.dto.CategoryDto;
import com.products.products.entity.Category;
import com.products.products.repository.CategoryRepository;
import com.products.products.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();

        return categoryList.stream().map(this::MapToDto).collect(Collectors.toList());
    }

    private CategoryDto MapToDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }

    private Category MapToEntity(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }
}
