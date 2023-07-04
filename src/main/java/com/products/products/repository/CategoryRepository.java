package com.products.products.repository;

import com.products.products.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository pour les catégories
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    boolean existsById(int categoryId);
}