package com.products.products.seed;

import com.products.products.entity.Category;
import com.products.products.entity.Product;
import com.products.products.repository.CategoryRepository;
import com.products.products.repository.ProductRepository;
import com.products.products.utils.NumberUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class DataSeeding implements CommandLineRunner {
    private final ProductRepository productRepository;
    private  final CategoryRepository categoryRepository;

    public DataSeeding(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategoryData();
        loadProductData();
    }

    private void loadCategoryData() {
        if(categoryRepository.count() == 0) {
            Category phone = Category.builder()
                    .id(1)
                    .name("Téléphone")
                    .build();
            Category tablette = Category.builder()
                    .id(2)
                    .name("Tablet")
                    .build();
            Category laptop = Category.builder()
                    .id(3)
                    .name("Laptop")
                    .build();

            categoryRepository.saveAll(Arrays.asList(phone, tablette, laptop));
        }
    }

    private void loadProductData() {
        if(productRepository.count() == 0) {

            List<Product> products = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                Product product = Product.builder()
                        .id(i)
                        .title("title" + i)
                        .description("description" + i)
                        .price((float) i)
                        .rating(NumberUtils.round((float) (Math.random() * 5), 1))
                        .stock(new Random().nextInt(150))
                        .discountPercentage(new Random().nextInt(90))
                        .category(Category.builder()
                                .id(1)
                                .name("Téléphone")
                                .build())
                        .build();

                products.add(product);
            }

            for (int i = 20; i < 40; i++) {
                Product product = Product.builder()
                        .id(i)
                        .title("title" + i)
                        .description("description" + i)
                        .price((float) i)
                        .rating(NumberUtils.round((float) (Math.random() * 5), 1))
                        .stock(new Random().nextInt(150))
                        .discountPercentage(new Random().nextInt(90))
                        .category(Category.builder()
                                .id(2)
                                .name("Tablet")
                                .build())
                        .build();

                products.add(product);
            }

            for (int i = 40; i < 60; i++) {
                Product product = Product.builder()
                        .id(i)
                        .title("title" + i)
                        .description("description" + i)
                        .price((float) i)
                        .rating(NumberUtils.round((float) (Math.random() * 5), 1))
                        .stock(new Random().nextInt(150))
                        .discountPercentage(new Random().nextInt(90))
                        .category(Category.builder()
                                .id(3)
                                .name("Laptop")
                                .build())
                        .build();

                products.add(product);
            }

            productRepository.saveAll(products);
        }
    }
}
