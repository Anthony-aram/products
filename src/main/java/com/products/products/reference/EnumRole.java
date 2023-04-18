package com.products.products.reference;

public enum EnumRole {
    ROLE_USER("Utilisateur"),
    ROLE_ADMIN("Administrateur");

    private final String label;

    EnumRole(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
