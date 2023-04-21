package com.products.products.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Builder
@Table(name = "roles")
@AllArgsConstructor
public class Role {
    @Id
    @Column(name = "code", nullable = false, updatable = false, length = 20)
    private String code;

    @Column(nullable = false, length = 20)
    private String label;
}
