package com.products.products.mapper;

import com.products.products.dto.BrandDto;
import com.products.products.entity.Brand;

public class BrandMapper {
    /**
     * Map a Brand to a BrandDto
     * @param brand Brand to map
     * @return BrandDto
     */
    public static BrandDto mapToDto(Brand brand) {
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
    public static Brand mapToEntity(BrandDto brandDto) {
        return Brand.builder()
                .id(brandDto.getId())
                .name(brandDto.getName())
                .build();
    }
}
