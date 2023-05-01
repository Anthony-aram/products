package com.products.products.mapper;

import com.products.products.dto.ProductDto;
import com.products.products.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Mapper pour les produits
 */
@RequiredArgsConstructor
@Service
public class ProductMapper implements Mapper<Product, ProductDto> {

    private final BrandMapper brandMapper;
    private final CategoryMapper categoryMapper;

    /**
     * Map a Product to a ProductDto
     * @param product Product to map
     * @return ProductDto
     */
    @Override
    public ProductDto mapToDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .discount_percentage(product.getDiscountPercentage())
                .rating(product.getRating())
                .stock(product.getStock())
                .thumbnail(product.getThumbnail())
                .images(product.getImages())
                .category(categoryMapper.mapToDto(product.getCategory()))
                .brand(brandMapper.mapToDto(product.getBrand()))
                .build();
    }

    /**
     * Map a ProductDto to Product
     * @param productDto Product to map
     * @return Product
     */
    @Override
    public Product mapToEntity(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .title(productDto.getTitle())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .discountPercentage(productDto.getDiscount_percentage())
                .rating(productDto.getRating())
                .stock(productDto.getStock())
                .thumbnail(productDto.getThumbnail())
                .images(productDto.getImages())
                .category(categoryMapper.mapToEntity(productDto.getCategory()))
                .brand(brandMapper.mapToEntity(productDto.getBrand()))
                .build();
    }
}
