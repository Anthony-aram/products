package com.products.products.mapper;

/**
 * Interface pour les mappers
 * @param <Entity> Entité
 * @param <Dto> Dto
 */
public interface Mapper<Entity, Dto> {

    /**
     * Convertit une entité en dto
     * @param entity Entité à convertir
     * @return Dto
     */
    Dto mapToDto(Entity entity);

    /**
     * Convertit un dto en entité
     * @param dto Dto à convertir
     * @return Entité
     */
    Entity mapToEntity(Dto dto);
}
