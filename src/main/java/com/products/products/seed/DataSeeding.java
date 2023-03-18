package com.products.products.seed;

import com.products.products.entity.Brand;
import com.products.products.entity.Category;
import com.products.products.entity.Product;
import com.products.products.repository.BrandRepository;
import com.products.products.repository.CategoryRepository;
import com.products.products.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataSeeding implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    public DataSeeding(ProductRepository productRepository, CategoryRepository categoryRepository,
                       BrandRepository brandRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        /**
         * Brands
         */
        if (brandRepository.count() == 0) {
            Brand apple = Brand.builder()
                    .id(1)
                    .name("Apple")
                    .build();
            Brand samsung = Brand.builder()
                    .id(2)
                    .name("Samsung")
                    .build();
            Brand oppo = Brand.builder()
                    .id(3)
                    .name("OPPO")
                    .build();
            Brand huawei = Brand.builder()
                    .id(4)
                    .name("Huawei")
                    .build();
            Brand microsoft_surface = Brand.builder()
                    .id(5)
                    .name("Microsoft Surface")
                    .build();
            Brand infinix = Brand.builder()
                    .id(6)
                    .name("Infinix")
                    .build();
            Brand hp_pavilion = Brand.builder()
                    .id(7)
                    .name("HP Pavilion")
                    .build();
            Brand impression_of_acqua_di_gio = Brand.builder()
                    .id(8)
                    .name("Impression of Acqua Di Gio")
                    .build();
            Brand royal_mirage = Brand.builder()
                    .id(9)
                    .name("Royal_Mirage")
                    .build();
            Brand fog_scent_xpressio = Brand.builder()
                    .id(10)
                    .name("Fog Scent Xpressio")
                    .build();
            Brand al_munakh = Brand.builder()
                    .id(11)
                    .name("Al Munakh")
                    .build();
            Brand lord_al_rehab = Brand.builder()
                    .id(12)
                    .name("Lord - Al-Rehab")
                    .build();
            Brand l_oreal_paris = Brand.builder()
                    .id(13)
                    .name("L'Oreal Paris")
                    .build();
            Brand hemani_tea = Brand.builder()
                    .id(14)
                    .name("Hemani Tea")
                    .build();
            Brand dermive = Brand.builder()
                    .id(15)
                    .name("Dermive")
                    .build();
            Brand rorec_white_rice = Brand.builder()
                    .id(16)
                    .name("ROREC White Rice")
                    .build();
            Brand fair_and_clear = Brand.builder()
                    .id(17)
                    .name("Fair & Clear")
                    .build();
            Brand saaf_and_khaas = Brand.builder()
                    .id(18)
                    .name("Saaf & Khaas")
                    .build();
            Brand bake_Parlor_big = Brand.builder()
                    .id(19)
                    .name("Bake Parlor Big")
                    .build();
            Brand baking_food_items = Brand.builder()
                    .id(20)
                    .name("Baking Food Items")
                    .build();
            Brand fauji = Brand.builder()
                    .id(21)
                    .name("fauji")
                    .build();
            Brand dry_rose = Brand.builder()
                    .id(22)
                    .name("Dry Rose")
                    .build();
            Brand boho_decor = Brand.builder()
                    .id(23)
                    .name("Boho Decor")
                    .build();
            Brand flying_wooden = Brand.builder()
                    .id(24)
                    .name("Flying Wooden")
                    .build();
            Brand led_lights = Brand.builder()
                    .id(25)
                    .name("LED Lights")
                    .build();
            Brand luxury_palace = Brand.builder()
                    .id(26)
                    .name("Luxury palace")
                    .build();
            Brand golden = Brand.builder()
                    .id(27)
                    .name("Golden")
                    .build();

            brandRepository.saveAll(Arrays.asList(apple, samsung, oppo, huawei, microsoft_surface, infinix, hp_pavilion,
                    impression_of_acqua_di_gio, royal_mirage, fog_scent_xpressio, al_munakh, lord_al_rehab,
                    l_oreal_paris, hemani_tea, dermive, rorec_white_rice, fair_and_clear, saaf_and_khaas,
                    bake_Parlor_big, baking_food_items, fauji, dry_rose, boho_decor, flying_wooden, led_lights,
                    luxury_palace, golden));
        }

        /**
         * Categories
         */
        if (categoryRepository.count() == 0) {
            Category smartphones = Category.builder()
                    .id(1)
                    .name("Smartphones")
                    .build();
            Category fragrances = Category.builder()
                    .id(2)
                    .name("Fragrances")
                    .build();
            Category laptops = Category.builder()
                    .id(3)
                    .name("Laptops")
                    .build();
            Category skincare = Category.builder()
                    .id(4)
                    .name("Skincare")
                    .build();
            Category groceries = Category.builder()
                    .id(5)
                    .name("Groceries")
                    .build();
            Category home_decoration = Category.builder()
                    .id(6)
                    .name("Home-decoration")
                    .build();

            categoryRepository.saveAll(Arrays.asList(smartphones, fragrances, laptops, skincare, groceries, home_decoration));
        }

        /**
         * Products
         */
        if (productRepository.count() == 0) {
            Product product = Product.builder()
                    .id(1)
                    .title("iPhone 9")
                    .description("An apple mobile which is nothing like apple")
                    .price(549F)
                    .discountPercentage(13)
                    .rating(4.69F)
                    .stock(94)
                    .thumbnail("https://i.dummyjson.com/data/products/1/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/1/1.jpg",
                            "https://i.dummyjson.com/data/products/1/2.jpg",
                            "https://i.dummyjson.com/data/products/1/3.jpg",
                            "https://i.dummyjson.com/data/products/1/4.jpg",
                            "https://i.dummyjson.com/data/products/1/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(1)
                            .name("Smartphones")
                            .build())
                    .brand(Brand.builder()
                            .id(1)
                            .name("Apple")
                            .build())
                    .build();

            productRepository.saveAll(Arrays.asList(product));
        }
    }
}
