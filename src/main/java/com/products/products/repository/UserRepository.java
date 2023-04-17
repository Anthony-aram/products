package com.products.products.repository;

import com.products.products.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * User repository
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Find a user by username
     * @param username Username
     * @return Found user
     */
    Optional<User> findByUsername(String username);

    /**
     * Check if a user exists
     * @param username Username
     * @return True if the user exists, otherwise false
     */
    Boolean existsByUsername(String username);
}