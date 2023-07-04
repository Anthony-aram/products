package com.products.products.service;

import com.products.products.dto.LoginDto;
import com.products.products.dto.RegisterDto;

/**
 * Service pour l'authentification
 */
public interface AuthService {

    /**
     * Connexion
     * @param loginDto LoginDto
     * @return Token
     */
    String login(LoginDto loginDto);

    /**
     * Inscription
     * @param registerDto RegisterDto
     * @return Token
     */
    String register(RegisterDto registerDto);
}
