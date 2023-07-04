package com.products.products.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO représentant une réponse d'authentification
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthResponse {

    /**
     * Token d'authentification
     */
    private String accessToken;

    /**
     * Type du token
     */
    private String tokenType = "Bearer";
}
