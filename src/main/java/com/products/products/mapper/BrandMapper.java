package com.products.products.mapper;

import com.products.products.dto.BrandDto;
import com.products.products.entity.Brand;
import org.springframework.stereotype.Service;

/**
 * Mapper pour les marques
 */
@Service
public class BrandMapper implements Mapper<Brand, BrandDto> {
    /**
     * Map a Brand to a BrandDto
     * @param brand Brand to map
     * @return BrandDto
     */
    @Override
    public BrandDto mapToDto(Brand brand) {
        return BrandDto.builder()
                .id(brand.getId())
                .name(brand.getName())
                .build();
    }

    /**
     * Map a Brand to a BrandDto
     * @param brandDto Brand to map
     * @return BrandDto
     */
    @Override
    public Brand mapToEntity(BrandDto brandDto) {
        return Brand.builder()
                .id(brandDto.getId())
                .name(brandDto.getName())
                .build();
    }
}
