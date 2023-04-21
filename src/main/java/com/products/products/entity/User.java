package com.products.products.entity;

import com.products.products.reference.RoleConverter;
import com.products.products.reference.RoleReference;
import jakarta.persistence.*;
import lombok.*;

/**
 * Représente un enregistrement de la table User
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;

    @Column(nullable = false, updatable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Convert(converter = RoleConverter.class)
    @Column(name = "role", nullable = false)
    private RoleReference role;
}
