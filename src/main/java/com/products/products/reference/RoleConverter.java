package com.products.products.reference;

import jakarta.persistence.Converter;

/**
 * Convertit un rôle from/to un enum
 */
@Converter(autoApply = true)
public class RoleConverter extends ReferenceConverter<RoleReference> {

    /**
     * @return les enums de référence
     */
    @Override
    protected RoleReference[] values() {
        return RoleReference.values();
    }
}
