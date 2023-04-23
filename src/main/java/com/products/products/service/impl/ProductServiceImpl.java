package com.products.products.service.impl;

import com.products.products.dto.PageResponse;
import com.products.products.dto.ProductDto;
import com.products.products.entity.Product;
import com.products.products.exception.ResourceNotFoundException;
import com.products.products.mapper.ProductMapper;
import com.products.products.repository.CategoryRepository;
import com.products.products.repository.ProductRepository;
import com.products.products.service.ProductService;
import com.products.products.specification.GenericSpecification;
import com.products.products.specification.SearchCriteria;
import com.products.products.specification.SearchOperation;
import com.products.products.specification.metaModel.Product_;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public PageResponse<ProductDto> getAllProducts(int pageNo, int pageSize, String sortBy, String sortDir, String title, String description, Integer minPrice, Integer maxPrice) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        // Create pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        GenericSpecification<Product> productSpecification = buildSpecification(title, description, minPrice, maxPrice);

        Page<Product> productPage = productRepository.findAll(productSpecification, pageable);

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
     * Construit une spécification
     * @param title Titre
     * @param description Description
     * @return La spécification
     */
    private GenericSpecification<Product> buildSpecification(String title, String description, Integer minPrice, Integer maxPrice) {
        GenericSpecification<Product> productSpecification = new GenericSpecification<>();
        // Title
        if(StringUtils.hasLength(title)) {
            productSpecification.add(new SearchCriteria(Product_.TITLE, SearchOperation.LIKE, title));
        }
        // Description
        if(StringUtils.hasLength(description)) {
            productSpecification.add(new SearchCriteria(Product_.DESCRIPTION, SearchOperation.LIKE, description));
        }
        if(minPrice != null) {
            productSpecification.add(new SearchCriteria(Product_.PRICE, SearchOperation.GREATER_THAN_EQUAL, minPrice));
        }
        if(maxPrice != null) {
            productSpecification.add(new SearchCriteria(Product_.PRICE, SearchOperation.LESS_THAN_EQUAL, maxPrice));
        }

        return productSpecification;
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
            throw new ResourceNotFoundException("Category", "id", String.valueOf(categoryId));
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
     * Récupère un produit par son titre
     * @param title Titre
     * @return Le produit
     */
    @Override
    public List<ProductDto> getProductsByTitle(String title) {
        return productRepository.findByTitleContaining(title)
                .stream()
                .map(ProductMapper::mapToDto)
                .collect(Collectors.toList());
    }

    /**
     * Get a product by id
     * @param productId Product id
     * @return Found product
     */
    @Override
    public ProductDto getProductById(int productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "id", String.valueOf(productId)));
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
    @Transactional
    public ProductDto updateProduct(ProductDto productDto, int productId) {
        Product foundProduct = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "id", String.valueOf(productId)));

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
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "id", String.valueOf(productId)));
        productRepository.delete(product);
    }
}
