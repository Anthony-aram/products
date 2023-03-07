package com.products.products.repository;

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
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void productRepository_save_returnSavedProduct() {
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

        Product savedProduct = productRepository.save(product);

        Assertions.assertThat(savedProduct).isNotNull();
        Assertions.assertThat(savedProduct.getId()).isGreaterThan(0);
    }

    @Test
    public void productRepository_getAll_returnMoreThanOneProduct() {
        Product product = Product.builder()
                .title("titleTest")
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
        Product product1 = Product.builder()
                .title("titleTest1")
                .description("description")
                .price(1F)
                .discountPercentage(10)
                .rating(1F)
                .stock(1)
                .category(
                        Category.builder()
                                .id(1)
                                .name("name1")
                                .build()
                ).build();

        productRepository.save(product);
        productRepository.save(product1);

        List<Product> productList = productRepository.findAll();

        Assertions.assertThat(productList).isNotNull();
        Assertions.assertThat(productList.size()).isGreaterThan(1);
    }

    @Test
    public void productRepository_findById_returnProduct() {
        Product product = Product.builder()
                .title("titleTest")
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

        productRepository.save(product);

        Product foundProduct = productRepository.findById(product.getId()).get();

        Assertions.assertThat(foundProduct).isNotNull();
    }

    @Test
    public void productRepository_updateProduct_returnProductNotNull() {
        Product product = Product.builder()
                .title("titleTest")
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

        productRepository.save(product);

        Product savedProduct = productRepository.findById(product.getId()).get();
        savedProduct.setTitle("title updated");

        Product updatedProduct = productRepository.save(savedProduct);

        Assertions.assertThat(updatedProduct.getTitle()).isNotNull();
        Assertions.assertThat(updatedProduct.getTitle()).isEqualTo("title updated");
    }

    @Test
    public void productRepository_deleteProduct_returnProductIsEmpty() {
        Product product = Product.builder()
                .title("titleTest")
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


        productRepository.save(product);

        productRepository.deleteById(product.getId());
        Optional<Product> productReturn = productRepository.findById(product.getId());

        Assertions.assertThat(productReturn).isEmpty();
    }
}
