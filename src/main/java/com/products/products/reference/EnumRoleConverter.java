package com.products.products.reference;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class EnumRoleConverter implements AttributeConverter<EnumRole, String> {
    @Override
    public String convertToDatabaseColumn(EnumRole enumRole) {
        return enumRole.getLabel();
    }

    @Override
    public EnumRole convertToEntityAttribute(String label) {
        for (EnumRole enumRole : EnumRole.values()) {
            if (enumRole.getLabel().equals(label)) {
                return enumRole;
            }
        }
        throw new IllegalArgumentException("Invalid label: " + label);
    }
}
