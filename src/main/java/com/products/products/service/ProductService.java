package com.products.products.service;

import com.products.products.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    List<ProductDto> getAllProductsByCategoryId(int categoryId);
    ProductDto getProductById(int productId);
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto, int id);
    void deleteProduct(int productId);
}
