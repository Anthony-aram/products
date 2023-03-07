package com.products.products.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.products.products.dto.CategoryDto;
import com.products.products.dto.PageResponse;
import com.products.products.dto.ProductDto;
import com.products.products.exception.ResourceNotFoundException;
import com.products.products.service.ProductService;
import com.products.products.utils.ConstantsUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(controllers = ProductController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;
    private CategoryDto categoryDto;
    private ProductDto productDto;

    @BeforeEach
    public void init() {
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
    }

    /**
     * Test GetAllProducts => Return PageResponse of products
     * @throws Exception Exception
     */
    @Test
    public void productController_getAllProducts_returnPageResponse() throws Exception {
        PageResponse<ProductDto> productResponse = new PageResponse<>(Collections.singletonList(productDto), 0, 10, 20, 2, false);
        when(productService.getAllProducts(0, 10, ConstantsUtils.DEFAULT_SORT_BY, ConstantsUtils.DEFAULT_SORT_DIRECTION)).thenReturn(productResponse);

        ResultActions response = mockMvc.perform(get("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .param("pageNo","0")
                .param("pageSize", "10"));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content.size()", CoreMatchers.is(productResponse.getContent().size())));
    }

    /**
     * Test GetProductsByCategoryId => Return PageResponse of products
     * @throws Exception Exception
     */
    @Test
    public void productController_getProductsByCategoryId_returnPageResponse() throws Exception {
        int categoryId = 1;
        PageResponse<ProductDto> productResponse = new PageResponse<>(Collections.singletonList(productDto), 0, 10, 20, 2, false);
        when(productService.getAllProductsByCategoryId(categoryId,0, 10, ConstantsUtils.DEFAULT_SORT_BY, ConstantsUtils.DEFAULT_SORT_DIRECTION)).thenReturn(productResponse);

        ResultActions response = mockMvc.perform(get("/api/products/category/1")
                .contentType(MediaType.APPLICATION_JSON)
                .param("pageNo","0")
                .param("pageSize", "10"));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content.size()", CoreMatchers.is(productResponse.getContent().size())));
    }

    /**
     * Test GetProductsByCategoryId => Return NotFound
     * @throws Exception Exception
     */
    @Test
    public void productController_getProductsByCategoryId_returnNotFound() throws Exception {
        int categoryId = 1;

        when(productService.getAllProductsByCategoryId(categoryId,0, 10, ConstantsUtils.DEFAULT_SORT_BY, ConstantsUtils.DEFAULT_SORT_DIRECTION)).thenThrow(ResourceNotFoundException.class);

        ResultActions response = mockMvc.perform(get("/api/products/category/1")
                .contentType(MediaType.APPLICATION_JSON)
                .param("pageNo","0")
                .param("pageSize", "10"));

        response.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Test GetProductById => Return found product
     * @throws Exception Exception
     */
    @Test
    public void productController_getProductById_returnProductDto() throws Exception {
        int productId = 1;

        when(productService.getProductById(productId)).thenReturn(productDto);

        ResultActions response = mockMvc.perform(get("/api/products/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(productDto)));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", CoreMatchers.is(productDto.getTitle())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description", CoreMatchers.is(productDto.getDescription())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.discountPercentage", CoreMatchers.is(productDto.getDiscountPercentage())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.stock", CoreMatchers.is(productDto.getStock())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.category.name", CoreMatchers.is(productDto.getCategory().getName())));
    }

    /**
     * Test GetProductById => Return NotFound
     * @throws Exception Exception
     */
    @Test
    public void productController_getProductById_returnNotFound() throws Exception {
        int productId = 1;

        when(productService.getProductById(productId)).thenThrow(ResourceNotFoundException.class);

        ResultActions response = mockMvc.perform(get("/api/products/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(productDto)));

        response.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Test CreateProduct => Return product
     * @throws Exception Exception
     */
    @Test
    public void productController_createProduct_returnProductDto() throws Exception {
        given(productService.createProduct(ArgumentMatchers.any())).willAnswer((invocation -> invocation.getArgument(0)));

        ResultActions response = mockMvc.perform(post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productDto)));

        response.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", CoreMatchers.is(productDto.getTitle())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description", CoreMatchers.is(productDto.getDescription())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.discountPercentage", CoreMatchers.is(productDto.getDiscountPercentage())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.stock", CoreMatchers.is(productDto.getStock())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.category.name", CoreMatchers.is(productDto.getCategory().getName())));
    }

    /**
     * Test UpdateProduct => Return product
     * @throws Exception Exception
     */
    @Test
    public void productController_updateProduct_returnProductDto() throws Exception {
        int productId = 1;

        when(productService.updateProduct(productDto, productId)).thenReturn(productDto);

        ResultActions response = mockMvc.perform(put("/api/products/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(productDto)));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", CoreMatchers.is(productDto.getTitle())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description", CoreMatchers.is(productDto.getDescription())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.discountPercentage", CoreMatchers.is(productDto.getDiscountPercentage())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.stock", CoreMatchers.is(productDto.getStock())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.category.name", CoreMatchers.is(productDto.getCategory().getName())));
    }

    /**
     * Test UpdateProduct => Return NotFound
     * @throws Exception Exception
     */
    @Test
    public void productController_updateProduct_returnNotFound() throws Exception {
        int productId = 1;

        when(productService.updateProduct(productDto, productId)).thenThrow(ResourceNotFoundException.class);

        ResultActions response = mockMvc.perform(put("/api/products/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(productDto)));

        response.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Test DeleteProduct => Return void
     * @throws Exception Exception
     */
    @Test
    public void productController_deleteProductById_returnVoid() throws Exception {
        int productId = 1;

        doNothing().when(productService).deleteProductById(productId);

        ResultActions response = mockMvc.perform(delete("/api/products/1")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Test DeleteProduct => Return NotFound
     * @throws Exception Exception
     */
    @Test
    public void productController_deleteProductById_returnNotFound() throws Exception {
        int productId = 1;

        doThrow(ResourceNotFoundException.class).when(productService).deleteProductById(productId);

        ResultActions response = mockMvc.perform(delete("/api/products/1")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
