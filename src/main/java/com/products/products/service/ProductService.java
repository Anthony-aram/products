package com.products.products.service;

import com.products.products.dto.PageResponse;
import com.products.products.dto.ProductDto;

public interface ProductService {
    PageResponse<ProductDto> getAllProducts(int pageNo, int pageSize, String sortBy, String sortDir);
    PageResponse<ProductDto> getAllProductsByCategoryId(int categoryId, int pageNo, int pageSize, String sortBy, String sortDir);
    ProductDto getProductById(int productId);
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto, int id);
    void deleteProductById(int productId);
}
