package com.products.products.repository;

import com.products.products.entity.Role;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository pour la table roles
 */
public interface RoleRepository extends JpaRepository<Role, String> {

    /**
     * Récupération de la liste des rôles
     * @return La liste des rôles
     */
    @Override
    @Cacheable(value = "roles")
    List<Role> findAll();
}