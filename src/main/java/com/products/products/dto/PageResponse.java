package com.products.products.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DTO représentant une réponse paginée
 * @param <T> Type de l'objet contenu dans la page
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResponse<T> {

    /**
     * Contenu de la page
     */
    private List<T> content;

    /**
     * Numéro de la page
     */
    private int pageNo;

    /**
     * Taille de la page
     */
    private int pageSize;

    /**
     * Nombre total d'éléments
     */
    private long totalElements;

    /**
     * Nombre total de pages
     */
    private int totalPages;

    /**
     * Indique si c'est la dernière page
     */
    private boolean last;
}
