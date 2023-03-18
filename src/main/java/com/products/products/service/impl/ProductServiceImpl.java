package com.products.products.service.impl;

import com.products.products.dto.PageResponse;
import com.products.products.dto.ProductDto;
import com.products.products.entity.Product;
import com.products.products.exception.ResourceNotFoundException;
import com.products.products.mapper.ProductMapper;
import com.products.products.repository.CategoryRepository;
import com.products.products.repository.ProductRepository;
import com.products.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    /**
     * Get all products
     * @param pageNo Page number
     * @param pageSize Page size
     * @param sortBy Sort by
     * @param sortDir Sort direction
     * @return PageResponse of products
     */
    @Override
    public PageResponse<ProductDto> getAllProducts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        // Create pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Product> productPage = productRepository.findAll(pageable);

        List<ProductDto> content = productPage.getContent().stream().map(ProductMapper::mapToDto).collect(Collectors.toList());

        return new PageResponse<>(
                content,
                productPage.getNumber(),
                productPage.getSize(),
                productPage.getTotalElements(),
                productPage.getTotalPages(),
                productPage.isLast()
        );
    }

    /**
     * Get all products of a category
     * @param categoryId Category id
     * @param pageNo Page number
     * @param pageSize Page size
     * @param sortBy Sort by
     * @param sortDir Sort direction
     * @return PageResponse of products for the category id
     */
    @Override
    public PageResponse<ProductDto> getAllProductsByCategoryId(int categoryId, int pageNo, int pageSize, String sortBy, String sortDir) {
        if(!categoryRepository.existsById(categoryId)) {
            throw new ResourceNotFoundException("Category", "id", categoryId);
        }

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        // Create pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Product> productPage = productRepository.findByCategoryId(categoryId, pageable);

        List<ProductDto> content = productPage.getContent().stream().map(ProductMapper::mapToDto).collect(Collectors.toList());

        return new PageResponse<>(
                content,
                productPage.getNumber(),
                productPage.getSize(),
                productPage.getTotalElements(),
                productPage.getTotalPages(),
                productPage.isLast()
        );
    }

    /**
     * Get a product by id
     * @param productId Product id
     * @return Found product
     */
    @Override
    public ProductDto getProductById(int productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
        return ProductMapper.mapToDto(product);
    }

    /**
     * Create a product
     * @param productDto Product to create
     * @return Created product
     */
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return ProductMapper.mapToDto(productRepository.save(ProductMapper.mapToEntity(productDto)));
    }

    /**
     * Update a product
     * @param productDto Product to update
     * @param productId Product id
     * @return Updated product
     */
    @Override
    public ProductDto updateProduct(ProductDto productDto, int productId) {
        Product foundProduct = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

        foundProduct.setTitle(productDto.getTitle());
        foundProduct.setDescription(productDto.getDescription());
        foundProduct.setPrice(productDto.getPrice());

        return ProductMapper.mapToDto(productRepository.save(foundProduct));
    }

    /**
     * Delete a product
     * @param productId Product id
     */
    @Override
    public void deleteProductById(int productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
        productRepository.delete(product);
    }
}
