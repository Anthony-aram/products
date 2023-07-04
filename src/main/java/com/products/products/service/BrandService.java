package com.products.products.service;

import com.products.products.dto.BrandDto;

import java.util.List;

/**
 * Service pour les marques
 */
public interface BrandService {

    /**
     * Récupère toutes les marques
     * @return Liste des marques
     */
    List<BrandDto> getAllBrands();
}
