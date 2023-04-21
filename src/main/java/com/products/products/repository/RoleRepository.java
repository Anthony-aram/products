package com.products.products.repository;

import com.products.products.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository pour la table roles
 */
public interface RoleRepository extends JpaRepository<Role, String> {
}