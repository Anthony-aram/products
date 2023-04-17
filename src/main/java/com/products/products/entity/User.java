package com.products.products.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;
}
