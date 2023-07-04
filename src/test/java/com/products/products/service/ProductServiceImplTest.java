package com.products.products.service;

import com.products.products.dto.BrandDto;
import com.products.products.dto.CategoryDto;
import com.products.products.dto.PageResponse;
import com.products.products.dto.ProductDto;
import com.products.products.entity.Brand;
import com.products.products.entity.Category;
import com.products.products.entity.Product;
import com.products.products.exception.ResourceNotFoundException;
import com.products.products.mapper.ProductMapper;
import com.products.products.repository.CategoryRepository;
import com.products.products.repository.ProductRepository;
import com.products.products.service.impl.ProductServiceImpl;
import com.products.products.specification.GenericSpecification;
import com.products.products.utils.ConstantsUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

/**
 * Classe de test pour le service ProductService
 */
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;
    @Mock
    CategoryRepository categoryRepository;
    @Mock
    ProductMapper productMapper;
    @InjectMocks
    ProductServiceImpl productServiceImpl;

    /**
     * Test GetAllProducts => Return PageResponse of products
     */
    @Test
    void productService_getAllProducts_returnPageResponse() {
        Product product = Product.builder()
                .title("title")
                .description("description")
                .price(1F)
                .discountPercentage(10)
                .rating(1F)
                .stock(1)
                .category(Category.builder()
                                .id(1)
                                .name("category")
                                .build())
                .brand(Brand.builder()
                        .id(1)
                        .name("brand")
                        .build())
                .build();
        Pageable pageable = PageRequest.of(1, 10);
        Page<Product> productPage = new PageImpl<>(List.of(product), pageable, 1);

        when(productRepository.findAll(Mockito.any(GenericSpecification.class), Mockito.any(Pageable.class))).thenReturn(productPage);

        PageResponse<ProductDto> productDtoList = productServiceImpl.getAllProducts(0, 10, ConstantsUtils.DEFAULT_SORT_BY, ConstantsUtils.DEFAULT_SORT_DIRECTION, null, null, null, null);

        Assertions.assertThat(productDtoList).isNotNull();
        Assertions.assertThat(productDtoList.getContent())
                .isNotEmpty()
                .size().isEqualTo(1);
    }

    /**
     * Test GetAllProductsByCategoryId => Return PageResponse of products for a category
     */
    @Test
    void productService_getAllProductsByCategoryId_returnPageResponse() {
        Product product = Product.builder()
                .title("title")
                .description("description")
                .price(1F)
                .discountPercentage(10)
                .rating(1F)
                .stock(1)
                .category(Category.builder()
                        .id(1)
                        .name("category")
                        .build())
                .brand(Brand.builder()
                        .id(1)
                        .name("brand")
                        .build())
                .build();

        Pageable pageable = PageRequest.of(1, 10);
        Page<Product> productPage = new PageImpl<>(List.of(product), pageable, 1);

        when(categoryRepository.existsById(1)).thenReturn(true);
        when(productRepository.findByCategoryId(anyInt(), Mockito.any(Pageable.class))).thenReturn(productPage);

        PageResponse<ProductDto> productDtoList = productServiceImpl.getAllProductsByCategoryId(1,0, 10, ConstantsUtils.DEFAULT_SORT_BY, ConstantsUtils.DEFAULT_SORT_DIRECTION);

        Assertions.assertThat(productDtoList).isNotNull();
        Assertions.assertThat(productDtoList.getContent())
                .isNotEmpty()
                .size().isEqualTo(1);
    }

    /**
     * Test GetAllProductsByCategoryId => Return NotFound
     */
    @Test
    void productService_getAllProductsByCategoryId_returnNotFound() {
        when(categoryRepository.existsById(1)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> productServiceImpl.getAllProductsByCategoryId(1,0, 10, ConstantsUtils.DEFAULT_SORT_BY, ConstantsUtils.DEFAULT_SORT_DIRECTION));
    }

    /**
     * Test GetProductById => Return Product
     */
    @Test
    void productService_getProductById_returnProduct() {
        Product product = Product.builder()
                .id(1)
                .title("title")
                .description("description")
                .price(1F)
                .discountPercentage(10)
                .rating(1F)
                .stock(1)
                .category(Category.builder()
                        .id(1)
                        .name("category")
                        .build())
                .brand(Brand.builder()
                        .id(1)
                        .name("brand")
                        .build())
                .build();

        ProductDto productDto = ProductDto.builder()
                .title("title")
                .description("description")
                .price(1F)
                .discount_percentage(10)
                .rating(1F)
                .stock(1)
                .category(CategoryDto.builder()
                        .id(1)
                        .name("category")
                        .build())
                .brand(BrandDto.builder()
                        .id(1)
                        .name("brand")
                        .build())
                .build();

        when(productRepository.findById(anyInt())).thenReturn(Optional.ofNullable(product));
        when(productMapper.mapToDto(any(Product.class))).thenReturn(productDto);

        ProductDto foundProductDto = productServiceImpl.getProductById(1);

        Assertions.assertThat(foundProductDto).isNotNull();
        Assertions.assertThat(foundProductDto).isInstanceOf(ProductDto.class);
        Assertions.assertThat(foundProductDto.getTitle()).isEqualTo(product.getTitle());
    }

    /**
     * Test GetProductById => Return NotFound
     */
    @Test
    void productService_getProductById_returnNotFound()  {
        when(productRepository.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> productServiceImpl.getProductById(1));
    }

    /**
     * Test CreateProduct => Return product
     */
    @Test
    void productService_createProduct_returnProduct() {
        Product product = Product.builder()
                .title("title")
                .description("description")
                .price(1F)
                .discountPercentage(10)
                .rating(1F)
                .stock(1)
                .category(Category.builder()
                        .id(1)
                        .name("category")
                        .build())
                .brand(Brand.builder()
                        .id(1)
                        .name("brand")
                        .build())
                .build();

        ProductDto productDto = ProductDto.builder()
                .title("title")
                .description("description")
                .price(1F)
                .discount_percentage(10)
                .rating(1F)
                .stock(1)
                .category(CategoryDto.builder()
                        .id(1)
                        .name("category")
                        .build())
                .brand(BrandDto.builder()
                        .id(1)
                        .name("brand")
                        .build())
                .build();

        when(productMapper.mapToEntity(any(ProductDto.class))).thenReturn(product);
        when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);
        when(productMapper.mapToDto(any(Product.class))).thenReturn(productDto);


        ProductDto savedProduct = productServiceImpl.createProduct(productDto);

        Assertions.assertThat(savedProduct).isNotNull();
        Assertions.assertThat(savedProduct.getTitle()).isEqualTo(productDto.getTitle());
    }

    /**
     * Test UpdateProduct => Return product
     */
    @Test
    void productService_updateProduct_returnProduct() {
        int productId = 1;
        Product product = Product.builder()
                .id(productId)
                .title("title")
                .description("description")
                .price(1F)
                .discountPercentage(10)
                .rating(1F)
                .stock(1)
                .category(Category.builder()
                        .id(1)
                        .name("category")
                        .build())
                .brand(Brand.builder()
                        .id(1)
                        .name("brand")
                        .build())
                .build();

        ProductDto productDto = ProductDto.builder()
                .id(productId)
                .title("title")
                .description("description")
                .price(1F)
                .discount_percentage(10)
                .rating(1F)
                .stock(1)
                .category(CategoryDto.builder()
                        .id(1)
                        .name("category")
                        .build())
                .brand(BrandDto.builder()
                        .id(1)
                        .name("brand")
                        .build())
                .build();

        when(productRepository.findById(anyInt())).thenReturn(Optional.ofNullable(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);
        when(productMapper.mapToDto(any(Product.class))).thenReturn(productDto);

        ProductDto updatedProduct = productServiceImpl.updateProduct(productDto, productId);

        Assertions.assertThat(updatedProduct).isNotNull();
        Assertions.assertThat(productDto.getTitle()).isEqualTo(updatedProduct.getTitle());
    }

    /**
     * Test UpdateProduct => Return NotFound
     */
    @Test
    void productService_updateProduct_returnNotFound() {
        ProductDto productDto = ProductDto.builder()
                .id(1)
                .title("title")
                .description("description")
                .price(1F)
                .discount_percentage(10)
                .rating(1F)
                .stock(1)
                .category(CategoryDto.builder()
                        .id(1)
                        .name("category")
                        .build())
                .brand(BrandDto.builder()
                        .id(1)
                        .name("brand")
                        .build())
                .build();

        when(productRepository.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> productServiceImpl.updateProduct(productDto, productDto.getId()));
    }

    /**
     * Test DeleteProduct => Return void
     */
    @Test
    void productService_deleteProduct_returnVoid() {
        Product product = Product.builder()
                .id(1)
                .title("title")
                .description("description")
                .price(1F)
                .discountPercentage(10)
                .rating(1F)
                .stock(1)
                .category(Category.builder()
                        .id(1)
                        .name("category")
                        .build())
                .brand(Brand.builder()
                        .id(1)
                        .name("brand")
                        .build())
                .build();

        when(productRepository.findById(anyInt())).thenReturn(Optional.ofNullable(product));
        doNothing().when(productRepository).delete(any(Product.class));

        assertAll(() -> productServiceImpl.deleteProductById(1));
    }

    /**
     * Test DeleteProduct => Return NotFound
     */
    @Test
    void productService_deleteProduct_returnNotFound() {
        when(productRepository.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> productServiceImpl.deleteProductById(1));
    }
}
