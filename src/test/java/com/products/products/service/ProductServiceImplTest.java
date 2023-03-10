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
import org.springframework.data.domain.Pageable;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

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
    public void productService_getAllProducts_returnPageResponse() {
        Page productList = Mockito.mock(Page.class);

        when(productRepository.findAll(Mockito.any(Pageable.class))).thenReturn(productList);

        PageResponse<ProductDto> productDtoList = productServiceImpl.getAllProducts(0, 10, ConstantsUtils.DEFAULT_SORT_BY, ConstantsUtils.DEFAULT_SORT_DIRECTION);

        Assertions.assertThat(productDtoList).isNotNull();
    }

    /**
     * Test GetAllProductsByCategoryId => Return PageResponse of products for a category
     */
    @Test
    public void productService_getAllProductsByCategoryId_returnPageResponse() {
        int categoryId = 1;
        Category category = Category.builder()
                .id(categoryId)
                .name("category")
                .build();

        Page<Product> productList = Mockito.mock(Page.class);

        when(categoryRepository.findById(categoryId)).thenReturn(Optional.ofNullable(category));
        when(productRepository.findByCategoryId(Mockito.any(Integer.class), Mockito.any(Pageable.class))).thenReturn(productList);

        PageResponse<ProductDto> productDtoList = productServiceImpl.getAllProductsByCategoryId(categoryId,0, 10, ConstantsUtils.DEFAULT_SORT_BY, ConstantsUtils.DEFAULT_SORT_DIRECTION);

        Assertions.assertThat(productDtoList).isNotNull();
    }

    /**
     * Test GetAllProductsByCategoryId => Return NotFound
     */
    @Test
    public void productService_getAllProductsByCategoryId_returnNotFound() {
        int categoryId = 1;

        when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> productServiceImpl.getAllProductsByCategoryId(categoryId,0, 10, ConstantsUtils.DEFAULT_SORT_BY, ConstantsUtils.DEFAULT_SORT_DIRECTION));
    }

    /**
     * Test GetProductById => Return Product
     */
    @Test
    public void productService_getProductById_returnProduct() {
        int productId = 1;
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

        when(productRepository.findById(productId)).thenReturn(Optional.ofNullable(product));

        ProductDto productDto = productServiceImpl.getProductById(productId);

        Assertions.assertThat(productDto).isNotNull();
    }

    /**
     * Test GetProductById => Return NotFound
     */
    @Test
    public void productService_getProductById_returnNotFound()  {
        int productId = 1;

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> productServiceImpl.getProductById(productId));
    }

    /**
     * Test CreateProduct => Return product
     */
    @Test
    public void productService_createProduct_returnProduct() {
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
    }

    /**
     * Test UpdateProduct => Return product
     */
    @Test
    public void productService_updateProduct_returnProduct() {
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

        when(productRepository.findById(productId)).thenReturn(Optional.ofNullable(product));
        when(productRepository.save(product)).thenReturn(product);

        ProductDto updatedProduct = productServiceImpl.updateProduct(productDto, productId);

        Assertions.assertThat(updatedProduct).isNotNull();
    }

    /**
     * Test UpdateProduct => Return NotFound
     */
    @Test
    public void productService_updateProduct_returnNotFound() {
        int productId = 1;

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

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> productServiceImpl.updateProduct(productDto, productId));
    }

    /**
     * Test DeleteProduct => Return void
     */
    @Test
    public void productService_deleteProduct_returnVoid() {
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

        when(productRepository.findById(productId)).thenReturn(Optional.ofNullable(product));
        doNothing().when(productRepository).delete(product);

        assertAll(() -> productServiceImpl.deleteProductById(productId));
    }

    /**
     * Test DeleteProduct => Return NotFound
     */
    @Test
    public void productService_deleteProduct_returnNotFound() {
        int productId = 1;

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> productServiceImpl.deleteProductById(productId));
    }
}
