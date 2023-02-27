package com.products.products.service;

import com.products.products.dto.PageResponse;
import com.products.products.dto.ProductDto;

import java.util.List;

public interface ProductService {
    PageResponse<ProductDto> getAllProducts(int pageNo, int pageSize, String sortBy, String sortDir);
    List<ProductDto> getAllProductsByCategoryId(int categoryId);
    ProductDto getProductById(int productId);
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto, int id);
    void deleteProduct(int productId);
}
