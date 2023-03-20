package com.products.products.repository;

import com.products.products.entity.Brand;
import com.products.products.entity.Category;
import com.products.products.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Test save => Return product
     */
    @Test
    void productRepository_save_returnProduct() {
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
                                .build())
                .brand(Brand.builder()
                        .id(1)
                        .name("brand")
                        .build())
                .build();

        Product savedProduct = productRepository.save(product);

        Assertions.assertThat(savedProduct).isNotNull();
        Assertions.assertThat(savedProduct.getId()).isGreaterThan(0);
    }

    /**
     * Test findAll => Return products
     */
    @Test
    void productRepository_getAll_returnProducts() {
        Product product = Product.builder()
                .title("titleTest")
                .description("description")
                .price(1F)
                .discountPercentage(10)
                .rating(1F)
                .stock(1)
                .category(Category.builder()
                                .id(1)
                                .name("name")
                                .build())
                .brand(Brand.builder()
                        .id(1)
                        .name("brand")
                        .build()).build();
        Product product1 = Product.builder()
                .title("titleTest1")
                .description("description")
                .price(1F)
                .discountPercentage(10)
                .rating(1F)
                .stock(1)
                .category(Category.builder()
                                .id(2)
                                .name("name1")
                                .build())
                .brand(Brand.builder()
                        .id(2)
                        .name("brand1")
                        .build())
                .build();

        productRepository.save(product);
        productRepository.save(product1);

        List<Product> productList = productRepository.findAll();

        Assertions.assertThat(productList).isNotNull();
        Assertions.assertThat(productList.size()).isGreaterThan(1);
    }

    /**
     * Test findById => Return product
     */
    @Test
    void productRepository_findById_returnProduct() {
        Product product = Product.builder()
                .title("titleTest")
                .description("description")
                .price(1F)
                .discountPercentage(10)
                .rating(1F)
                .stock(1)
                .category(Category.builder()
                        .id(2)
                        .name("name1")
                        .build())
                .brand(Brand.builder()
                        .id(2)
                        .name("brand1")
                        .build())
                .build();

        productRepository.save(product);

        Product foundProduct = productRepository.findById(product.getId()).get();

        Assertions.assertThat(foundProduct).isNotNull();
    }

    /**
     * Test save => Return product
     */
    @Test
    void productRepository_updateProduct_returnProduct() {
        Product product = Product.builder()
                .title("titleTest")
                .description("description")
                .price(1F)
                .discountPercentage(10)
                .rating(1F)
                .stock(1)
                .category(Category.builder()
                        .id(2)
                        .name("name1")
                        .build())
                .brand(Brand.builder()
                        .id(2)
                        .name("brand1")
                        .build())
                .build();

        productRepository.save(product);

        Product savedProduct = productRepository.findById(product.getId()).get();
        savedProduct.setTitle("title updated");

        Product updatedProduct = productRepository.save(savedProduct);

        Assertions.assertThat(updatedProduct.getTitle()).isNotNull();
        Assertions.assertThat(updatedProduct.getTitle()).isEqualTo("title updated");
    }

    /**
     * Test delete => Return void
     */
    @Test
    void productRepository_deleteProduct_returnProductIsEmpty() {
        Product product = Product.builder()
                .title("titleTest")
                .description("description")
                .price(1F)
                .discountPercentage(10)
                .rating(1F)
                .stock(1)
                .category(Category.builder()
                        .id(2)
                        .name("name1")
                        .build())
                .brand(Brand.builder()
                        .id(2)
                        .name("brand1")
                        .build())
                .build();


        productRepository.save(product);

        productRepository.deleteById(product.getId());
        Optional<Product> productReturn = productRepository.findById(product.getId());

        Assertions.assertThat(productReturn).isEmpty();
    }
}
