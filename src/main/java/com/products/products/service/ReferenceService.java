package com.products.products.service;

import com.products.products.entity.Role;
import com.products.products.reference.RoleReference;

import java.util.List;

/**
 * Permet de récupérer les références en base
 */
public interface ReferenceService {

    /**
     * Récupère une entité role depuis une reférence role
     * @param reference La référence du role
     * @return Une entité role
     */
    Role role(RoleReference reference);

    /**
     * Récupère toutes les entités role
     * @return Une liste d'entités role
     */
    List<Role> getRoles();
}
