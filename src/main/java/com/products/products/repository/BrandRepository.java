package com.products.products.repository;

import com.products.products.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository pour les marques
 */
public interface BrandRepository extends JpaRepository<Brand, Integer> {
}