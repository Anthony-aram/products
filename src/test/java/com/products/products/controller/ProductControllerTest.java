package com.products.products.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.products.products.dto.CategoryDto;
import com.products.products.dto.PageResponse;
import com.products.products.dto.ProductDto;
import com.products.products.service.ProductService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = ProductController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductService productService;
    @Autowired
    private ObjectMapper objectMapper;
    private CategoryDto categoryDto;
    private ProductDto productDto;
    private PageResponse<ProductDto> pageResponse;

    /*@BeforeEach
    void init() {
        categoryDto = CategoryDto.builder()
                .name("name")
                .build();

        productDto = ProductDto.builder()
                .title("title")
                .description("description")
                .price(1F)
                .discountPercentage(10)
                .rating(1F)
                .stock(1)
                .category(categoryDto)
                .build();

        pageResponse = new PageResponse<>(Collections.singletonList(productDto), 0, 10, 20, 2, false);
    }

    *//**
     * Test GetAllProducts => Return PageResponse of products
     * @throws Exception Exception
     *//*
    @Test
    void productController_getAllProducts_returnPageResponse() throws Exception {
        when(productService.getAllProducts(anyInt(), anyInt(), anyString(), anyString())).thenReturn(pageResponse);

        mockMvc.perform(get("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .param("pageNo","0")
                .param("pageSize", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].title").value("title"));
    }

    *//**
     * Test GetProductsByCategoryId => Return PageResponse of products
     * @throws Exception Exception
     *//*
    @Test
    void productController_getProductsByCategoryId_returnPageResponse() throws Exception {
        when(productService.getAllProductsByCategoryId(anyInt(), anyInt(), anyInt(), anyString(), anyString())).thenReturn(pageResponse);

        mockMvc.perform(get("/api/products/category/1")
                .contentType(MediaType.APPLICATION_JSON)
                .param("pageNo","0")
                .param("pageSize", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].title").value("title"));
    }

    *//**
     * Test GetProductsByCategoryId => Return NotFound
     * @throws Exception Exception
     *//*
    @Test
    void productController_getProductsByCategoryId_returnNotFound() throws Exception {
        when(productService.getAllProductsByCategoryId(anyInt(), anyInt(), anyInt(), anyString(), anyString())).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(get("/api/products/category/1")
                .contentType(MediaType.APPLICATION_JSON)
                .param("pageNo","0")
                .param("pageSize", "10"))
                .andExpect(status().isNotFound());
    }

    *//**
     * Test GetProductById => Return found product
     * @throws Exception Exception
     *//*
    @Test
    void productController_getProductById_returnProductDto() throws Exception {
        when(productService.getProductById(anyInt())).thenReturn(productDto);

        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..title").value("title"));
    }

    *//**
     * Test GetProductById => Return NotFound
     * @throws Exception Exception
     *//*
    @Test
    void productController_getProductById_returnNotFound() throws Exception {
        when(productService.getProductById(anyInt())).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isNotFound());
    }

    *//**
     * Test CreateProduct => Return product
     * @throws Exception Exception
     *//*
    @Test
    void productController_createProduct_returnProductDto() throws Exception {
        when(productService.createProduct(any(ProductDto.class))).thenReturn(productDto);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("title"));
    }

    *//**
     * Test UpdateProduct => Return product
     * @throws Exception Exception
     *//*
    @Test
    void productController_updateProduct_returnProductDto() throws Exception {
        when(productService.updateProduct(any(ProductDto.class), anyInt())).thenReturn(productDto);

        mockMvc.perform(put("/api/products/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(productDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", CoreMatchers.is(productDto.getTitle())));
    }

    *//**
     * Test UpdateProduct => Return NotFound
     * @throws Exception Exception
     *//*
    @Test
    void productController_updateProduct_returnNotFound() throws Exception {
        when(productService.updateProduct(any(ProductDto.class), anyInt())).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(put("/api/products/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(productDto)))
                .andExpect(status().isNotFound());
    }

    *//**
     * Test DeleteProduct => Return void
     * @throws Exception Exception
     *//*
    @Test
    void productController_deleteProductById_returnVoid() throws Exception {
        doNothing().when(productService).deleteProductById(anyInt());

        mockMvc.perform(delete("/api/products/1"))
                .andExpect(status().isNoContent());
    }

    *//**
     * Test DeleteProduct => Return NotFound
     * @throws Exception Exception
     *//*
    @Test
    void productController_deleteProductById_returnNotFound() throws Exception {
        doThrow(ResourceNotFoundException.class).when(productService).deleteProductById(anyInt());

        mockMvc.perform(delete("/api/products/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }*/
}
