package com.products.products.service.impl;

import com.products.products.dto.ProductDto;
import com.products.products.entity.Product;
import com.products.products.repository.ProductRepository;
import com.products.products.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDto> getAllProducts() {
       return productRepository.findAll().stream().map(this::MapToDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getAllByCategoryId(int categoryId) {
        return productRepository.findByCategoryId(categoryId).stream().map(this::MapToDto).collect(Collectors.toList());
    }

    private ProductDto MapToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    private Product MapToEntity(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }
}
