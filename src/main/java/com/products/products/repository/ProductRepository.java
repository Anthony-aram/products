package com.products.products.repository;

import com.products.products.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Repository pour les produits
 */
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

    Page<Product> findByTitleContaining(Pageable pageable, String title);

    /**
     * Réccupère les produits par catégorie
     * @param id Id de la catégorie
     * @param pageable Pageable
     * @return Page de produits
     */
    Page<Product> findByCategoryId(int id, Pageable pageable);


    /**
     * Récupère un produit par son titre
     * @param title Titre
     * @return Le produit
     */
    List<Product> findByTitleContaining(String title);
}