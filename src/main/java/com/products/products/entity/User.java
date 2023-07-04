package com.products.products.entity;

import com.products.products.reference.RoleConverter;
import com.products.products.reference.RoleReference;
import jakarta.persistence.*;
import lombok.*;

/**
 * Entité représentant un utilisateur
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(
        name = "users",
        uniqueConstraints = { @UniqueConstraint(name = "UQ_Users_Username", columnNames = { "username" }) }
)
public class User {

    /**
     * Identifiant de l'utilisateur
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;

    /**
     * Nom d'utilisateur
     */
    @Column(nullable = false, updatable = false, length = 100)
    private String username;

    /**
     * Mot de passe
     */
    @Column(nullable = false, length = 100)
    private String password;

    /**
     * Rôle de l'utilisateur
     */
    @Convert(converter = RoleConverter.class)
    @Column(name = "role", nullable = false)
    private RoleReference role;
}
