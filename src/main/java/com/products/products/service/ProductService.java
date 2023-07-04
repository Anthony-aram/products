package com.products.products.service;

import com.products.products.dto.PageResponse;
import com.products.products.dto.ProductDto;

/**
 * Interface ProductService
 */
public interface ProductService {

    /**
     * Récupère une liste de produits paginée et triée
     * @param pageNo Numero de page
     * @param pageSize Taille de la page
     * @param sortBy Champ de tri
     * @param sortDir Direction du tri
     * @param title Titre
     * @param description Description
     * @param minPrice Prix minimum
     * @param maxPrice Prix maximum
     * @return Liste de produits paginée et triée
     */
    PageResponse<ProductDto> getAllProducts(int pageNo, int pageSize, String sortBy, String sortDir, String title, String description, Integer minPrice, Integer maxPrice);

    /**
     * Récupère une liste de produits paginée et triée par catégorie
     * @param categoryId Id de la catégorie
     * @param pageNo Numero de page
     * @param pageSize Taille de la page
     * @param sortBy Champ de tri
     * @param sortDir Direction du tri
     * @return Liste de produits paginée et triée par catégorie
     */
    PageResponse<ProductDto> getAllProductsByCategoryId(int categoryId, int pageNo, int pageSize, String sortBy, String sortDir);

    /**
     * Récupère un produit par son id
     * @param productId Id du produit
     * @return Produit
     */
    ProductDto getProductById(int productId);

    /**
     * Crée un produit
     * @param productDto Produit à créer
     * @return Produit créé
     */
    ProductDto createProduct(ProductDto productDto);

    /**
     * Met à jour un produit
     * @param productDto Produit à mettre à jour
     * @param productId Id du produit à mettre à jour
     * @return Produit mis à jour
     */
    ProductDto updateProduct(ProductDto productDto, int productId);

    /**
     * Supprime un produit
     * @param productId Id du produit à supprimer
     */
    void deleteProductById(int productId);
}
