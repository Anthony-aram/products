package com.products.products.service;

import com.products.products.dto.PageResponse;
import com.products.products.dto.ProductDto;

import java.util.List;

public interface ProductService {
    PageResponse<ProductDto> getAllProducts(int pageNo, int pageSize, String sortBy, String sortDir, String title, String description, Integer minPrice, Integer maxPrice);
    PageResponse<ProductDto> getAllProductsByCategoryId(int categoryId, int pageNo, int pageSize, String sortBy, String sortDir);
    List<ProductDto> getProductsByTitle(String title);
    ProductDto getProductById(int productId);
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto, int productId);
    void deleteProductById(int productId);
}
