package com.products.products.service;

import com.products.products.dto.CategoryDto;

import java.util.List;

/**
 * Service pour les catégories
 */
public interface CategoryService {

    /**
     * Récupère toutes les catégories
     * @return Liste des catégories
     */
    List<CategoryDto> getAllCategories();
}
