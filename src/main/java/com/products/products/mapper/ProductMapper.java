package com.products.products.mapper;

import com.products.products.dto.ProductDto;
import com.products.products.entity.Product;
import com.products.products.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductMapper {

    private final CategoryRepository categoryRepository;

    /**
     * Map a Product to a ProductDto
     * @param product Product to map
     * @return ProductDto
     */
    public static ProductDto mapToDto(Product product) {
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
                .category(CategoryMapper.mapToDto(product.getCategory()))
                .brand(BrandMapper.mapToDto(product.getBrand()))
                .build();
    }

    /**
     * Map a ProductDto to Product
     * @param productDto Product to map
     * @return Product
     */
    public static Product mapToEntity(ProductDto productDto) {
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
                .category(CategoryMapper.mapToEntity(productDto.getCategory()))
                .brand(BrandMapper.mapToEntity(productDto.getBrand()))
                .build();
    }
}
