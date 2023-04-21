package com.products.products.reference;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

/**
 * Convertit une référence en from/to enum
 */
@Converter
public abstract class ReferenceConverter<T extends Reference> implements AttributeConverter<T, String> {

    /**
     * Convertit une référence en code
     * @param reference Référence
     * @return Le code de la référence
     */
    @Override
    public String convertToDatabaseColumn(T reference) {
        if (reference == null) {
            return null;
        }
        return reference.asCode();
    }

    /**
     * Convertit un code en référence
     * @param code Code
     * @return La référence
     */
    @Override
    public T convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(values())
                .filter(c -> c.asCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    /**
     * @return les enums de référence
     */
    protected abstract T[] values();
}
