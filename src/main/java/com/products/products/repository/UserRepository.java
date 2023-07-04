package com.products.products.repository;

import com.products.products.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository pour les utilisateurs
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Récupère un utilisateur par son username
     * @param username Nom d'utilisateur
     * @return L'utilisateur
     */
    Optional<User> findByUsername(String username);

    /**
     * Vérifie si un utilisateur existe par son username
     * @param username Nom d'utilisateur
     * @return Vrai si l'utilisateur existe
     */
    Boolean existsByUsername(String username);
}