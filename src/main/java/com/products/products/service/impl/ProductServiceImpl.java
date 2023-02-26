package com.products.products.service.impl;

import com.products.products.dto.ProductDto;
import com.products.products.entity.Product;
import com.products.products.repository.ProductRepository;
import com.products.products.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> productList = productRepository.findAll();

        return productList.stream().map(this::MapToDto).collect(Collectors.toList());
    }

    private ProductDto MapToDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .discountPercentage(product.getDiscountPercentage())
                .rating(product.getRating())
                .stock(product.getStock())
                .images(product.getImages())
                .build();
    }

    private Product MapToEntity(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .title(productDto.getTitle())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .discountPercentage(productDto.getDiscountPercentage())
                .rating(productDto.getRating())
                .stock(productDto.getStock())
                .images(productDto.getImages())
                .build();
    }
}
