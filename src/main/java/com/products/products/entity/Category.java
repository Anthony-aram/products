package com.products.products.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * Entité représentant une catégorie
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        name = "Categories",
        uniqueConstraints = { @UniqueConstraint(name = "UQ_Categories_Name", columnNames = { "name" }) }
)
public class Category {

    /**
     * Identifiant de la catégorie
     */
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;

    /**
     * Nom de la catégorie
     */
    @Column(nullable = false)
    @Size(min = 3, max = 30)
    private String name;

    /**
     * Date de création de la catégorie
     */
    @CreationTimestamp
    private LocalDateTime dateCreated;

    /**
     * Date de dernière mise à jour de la catégorie
     */
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
}
