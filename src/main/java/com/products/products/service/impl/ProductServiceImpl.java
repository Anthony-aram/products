package com.products.products.service.impl;

import com.products.products.dto.PageResponse;
import com.products.products.dto.ProductDto;
import com.products.products.entity.Product;
import com.products.products.exception.ResourceNotFoundException;
import com.products.products.repository.ProductRepository;
import com.products.products.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public PageResponse<ProductDto> getAllProducts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        // Create pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Product> productPage = productRepository.findAll(pageable);

        List<ProductDto> content = productPage.getContent().stream().map(this::mapToDto).collect(Collectors.toList());

        PageResponse<ProductDto> productResponse = new PageResponse<>(
                content,
                productPage.getNumber(),
                productPage.getSize(),
                productPage.getTotalElements(),
                productPage.getTotalPages(),
                productPage.isLast()
        );

       return productResponse;
    }

    @Override
    public List<ProductDto> getAllProductsByCategoryId(int categoryId) {
        return productRepository.findByCategoryId(categoryId).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(int productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return mapToDto(product);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return mapToDto(productRepository.save(mapToEntity(productDto)));
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, int id) {
        Product foundProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        foundProduct.setTitle(productDto.getTitle());
        foundProduct.setDescription(productDto.getDescription());
        foundProduct.setPrice(productDto.getPrice());

        return mapToDto(productRepository.save(foundProduct));
    }

    @Override
    public void deleteProduct(int productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        productRepository.delete(product);
    }

    private ProductDto mapToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    private Product mapToEntity(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }
}
