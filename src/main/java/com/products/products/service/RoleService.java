package com.products.products.service;

import com.products.products.entity.Role;

import java.util.List;

/**
 * Service pour les rôles
 */
public interface RoleService {

    /**
     * Récupère tous les rôles
     * @return La liste des rôles
     */
    List<Role> getAll();
}
