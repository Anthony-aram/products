package com.products.products.service;

import com.products.products.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    List<ProductDto> getAllByCategoryId(int categoryId);
}
