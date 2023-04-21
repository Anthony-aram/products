package com.products.products.reference;

/**
 * Les rôles connus
 */
public enum RoleReference implements Reference {
    ROLE_ADMIN("Administrateur"),
    ROLE_USER("Utilisateur");

    private final String code;

    RoleReference(String code) {
        this.code = code;
    }

    @Override
    public String asCode() {
        return code;
    }
}
