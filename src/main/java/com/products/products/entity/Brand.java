package com.products.products.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * Entité représentant une marque
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        name = "Brands",
        uniqueConstraints = { @UniqueConstraint(name = "UQ_Brands_Name", columnNames = { "name" }) }
)
public class Brand {

    /**
     * Identifiant de la marque
     */
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;

    /**
     * Nom de la marque
     */
    @Column(nullable = false)
    @Size(min = 3, max = 30)
    private String name;

    /**
     * Date de création de la marque
     */
    @CreationTimestamp
    private LocalDateTime dateCreated;

    /**
     * Date de dernière mise à jour de la marque
     */
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
}