package com.products.products.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Représente un enregistrement de la table Role
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(
        name = "roles",
        uniqueConstraints = { @UniqueConstraint(name = "UQ_Roles_Name", columnNames = { "name" }) })
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;
    @Column(nullable = false, length = 100)
    private String name;
}
