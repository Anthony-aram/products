package com.products.products.service;

import com.products.products.dto.CategoryDto;
import com.products.products.dto.PageResponse;
import com.products.products.dto.ProductDto;
import com.products.products.entity.Category;
import com.products.products.entity.Product;
import com.products.products.exception.ResourceNotFoundException;
import com.products.products.repository.CategoryRepository;
import com.products.products.repository.ProductRepository;
import com.products.products.service.impl.ProductServiceImpl;
import com.products.products.utils.ConstantsUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
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

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @Mock
    CategoryRepository categoryRepository;

    @Spy
    ModelMapper modelMapper;

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
                .category(
                        Category.builder()
                                .id(1)
                                .name("name")
                                .build()
                ).build();
        Pageable pageable = PageRequest.of(1, 10);
       Page<Product> productPage = new PageImpl<>(List.of(product), pageable, 1);

        when(productRepository.findAll(Mockito.any(Pageable.class))).thenReturn(productPage);

        PageResponse<ProductDto> productDtoList = productServiceImpl.getAllProducts(0, 10, ConstantsUtils.DEFAULT_SORT_BY, ConstantsUtils.DEFAULT_SORT_DIRECTION);

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
                .category(
                        Category.builder()
                                .id(1)
                                .name("name")
                                .build()
                ).build();
        Category category = Category.builder()
                .id(1)
                .name("category")
                .build();
        Pageable pageable = PageRequest.of(1, 10);
        Page<Product> productPage = new PageImpl<>(List.of(product), pageable, 1);

        when(categoryRepository.findById(anyInt())).thenReturn(Optional.ofNullable(category));
        when(productRepository.findByCategoryId(Mockito.any(Integer.class), Mockito.any(Pageable.class))).thenReturn(productPage);

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
        when(categoryRepository.findById(anyInt())).thenReturn(Optional.empty());

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
                .category(
                        Category.builder()
                                .id(1)
                                .name("name")
                                .build()
                ).build();

        when(productRepository.findById(anyInt())).thenReturn(Optional.ofNullable(product));

        ProductDto productDto = productServiceImpl.getProductById(1);

        Assertions.assertThat(productDto).isNotNull();
        Assertions.assertThat(productDto).isInstanceOf(ProductDto.class);
        Assertions.assertThat(productDto.getTitle()).isEqualTo(product.getTitle());
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
                .category(
                        Category.builder()
                                .id(1)
                                .name("name")
                                .build()
                ).build();

        ProductDto productDto = ProductDto.builder()
                .title("title")
                .description("description")
                .price(1F)
                .discountPercentage(10)
                .rating(1F)
                .stock(1)
                .category(
                        CategoryDto.builder()
                                .id(1)
                                .name("name")
                                .build()
                ).build();

        when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);
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
                .category(
                        Category.builder()
                                .id(1)
                                .name("name")
                                .build()
                ).build();

        ProductDto productDto = ProductDto.builder()
                .id(productId)
                .title("title")
                .description("description")
                .price(1F)
                .discountPercentage(10)
                .rating(1F)
                .stock(1)
                .category(
                        CategoryDto.builder()
                                .id(1)
                                .name("name")
                                .build()
                ).build();

        when(productRepository.findById(anyInt())).thenReturn(Optional.ofNullable(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        ProductDto updatedProduct = productServiceImpl.updateProduct(productDto, productId);

        Assertions.assertThat(updatedProduct).isNotNull();
        Assertions.assertThat(productDto.getTitle()).isEqualTo(productDto.getTitle());
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
                .discountPercentage(10)
                .rating(1F)
                .stock(1)
                .category(
                        CategoryDto.builder()
                                .id(1)
                                .name("name")
                                .build()
                ).build();

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
                .category(
                        Category.builder()
                                .id(1)
                                .name("name")
                                .build()
                ).build();

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
