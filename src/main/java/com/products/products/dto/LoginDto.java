package com.products.products.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO représentant une authentification
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    /**
     * Nom d'utilisateur
     */
    private String username;

    /**
     * Mot de passe
     */
    private String password;
}
