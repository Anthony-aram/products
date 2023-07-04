package com.products.products.seed;

import com.products.products.entity.*;
import com.products.products.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Classe pour l'initialisation des données
 */
@Component
@RequiredArgsConstructor
public class DataSeeding implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        loadData();
    }

    /**
     * Chargement des données
     */
    private void loadData() {
        // Roles
        if(roleRepository.count() == 0) {
            Role admin = Role.builder()
                    .code("ROLE_ADMIN")
                    .label("Administrateur")
                    .build();
            Role user = Role.builder()
                    .code("ROLE_USER")
                    .label("Utilisateur")
                    .build();

            roleRepository.saveAll(Arrays.asList(admin, user));
        }

        // Brands
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

        // Categories
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

        // Products
        if (productRepository.count() == 0) {
            Product iphone_9 = Product.builder()
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

            Product iphone_x = Product.builder()
                    .id(2)
                    .title("iPhone X")
                    .description("SIM-Free, Model A19211 6.5-inch Super Retina HD display with OLED technology A12 Bionic chip with ...")
                    .price(899F)
                    .discountPercentage(18)
                    .rating(4.44F)
                    .stock(34)
                    .thumbnail("https://i.dummyjson.com/data/products/2/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/2/1.jpg",
                            "https://i.dummyjson.com/data/products/2/2.jpg",
                            "https://i.dummyjson.com/data/products/2/3.jpg",
                            "https://i.dummyjson.com/data/products/2/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(1)
                            .name("Smartphones")
                            .build())
                    .brand(Brand.builder()
                            .id(1)
                            .name("Apple")
                            .build())
                    .build();

            Product samsung_universe_9 = Product.builder()
                    .id(3)
                    .title("Samsung Universe 9")
                    .description("Samsung's new variant which goes beyond Galaxy to the Universe")
                    .price(1249F)
                    .discountPercentage(16)
                    .rating(4.09F)
                    .stock(36)
                    .thumbnail("https://i.dummyjson.com/data/products/3/thumbnail.jpg")
                    .images(new HashSet<>(List.of(
                            "https://i.dummyjson.com/data/products/3/1.jpg")))
                    .category(Category.builder()
                            .id(1)
                            .name("Smartphones")
                            .build())
                    .brand(Brand.builder()
                            .id(2)
                            .name("Samsung")
                            .build())
                    .build();

            Product oppo_f_19 = Product.builder()
                    .id(4)
                    .title("OPPOF19")
                    .description("OPPO F19 is officially announced on April 2021.")
                    .price(280F)
                    .discountPercentage(18)
                    .rating(4.3F)
                    .stock(123)
                    .thumbnail("https://i.dummyjson.com/data/products/4/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/4/1.jpg",
                            "https://i.dummyjson.com/data/products/4/2.jpg",
                            "https://i.dummyjson.com/data/products/4/3.jpg",
                            "https://i.dummyjson.com/data/products/4/4.jpg",
                            "https://i.dummyjson.com/data/products/4/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(1)
                            .name("Smartphones")
                            .build())
                    .brand(Brand.builder()
                            .id(3)
                            .name("OPPO")
                            .build())
                    .build();

            Product huawei_p_30 = Product.builder()
                    .id(5)
                    .title("Huawei P30")
                    .description("Huawei’s re-badged P30 Pro New Edition was officially unveiled yesterday in Germany and now the device has made its way to the UK.")
                    .price(499F)
                    .discountPercentage(11)
                    .rating(4.09F)
                    .stock(32)
                    .thumbnail("https://i.dummyjson.com/data/products/5/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/5/1.jpg",
                            "https://i.dummyjson.com/data/products/5/2.jpg",
                            "https://i.dummyjson.com/data/products/5/3.jpg")))
                    .category(Category.builder()
                            .id(1)
                            .name("Smartphones")
                            .build())
                    .brand(Brand.builder()
                            .id(4)
                            .name("Huawei")
                            .build())
                    .build();

            Product mac_book_pro = Product.builder()
                    .id(6)
                    .title("MacBook Pro")
                    .description("MacBook Pro 2021 with mini-LED display may launch between September, November")
                    .price(1749F)
                    .discountPercentage(11)
                    .rating(4.57F)
                    .stock(83)
                    .thumbnail("https://i.dummyjson.com/data/products/6/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/6/1.png",
                            "https://i.dummyjson.com/data/products/6/2.jpg",
                            "https://i.dummyjson.com/data/products/6/3.png",
                            "https://i.dummyjson.com/data/products/6/4.jpg")))
                    .category(Category.builder()
                            .id(3)
                            .name("Laptops")
                            .build())
                    .brand(Brand.builder()
                            .id(1)
                            .name("Apple")
                            .build())
                    .build();

            Product samsung_galaxy_book = Product.builder()
                    .id(7)
                    .title("Samsung Galaxy Book")
                    .description("Samsung Galaxy Book S (2020) Laptop With Intel Lakefield Chip, 8GB of RAM Launched")
                    .price(1499F)
                    .discountPercentage(4)
                    .rating(4.25F)
                    .stock(50)
                    .thumbnail("https://i.dummyjson.com/data/products/7/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/7/1.jpg",
                            "https://i.dummyjson.com/data/products/7/2.jpg",
                            "https://i.dummyjson.com/data/products/7/3.jpg",
                            "https://i.dummyjson.com/data/products/7/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(3)
                            .name("Laptops")
                            .build())
                    .brand(Brand.builder()
                            .id(2)
                            .name("Samsung")
                            .build())
                    .build();

            Product microsoft_surface_laptop_4 = Product.builder()
                    .id(8)
                    .title("Microsoft Surface Laptop 4")
                    .description("Style and speed. Stand out on HD video calls backed by Studio Mics. Capture ideas on the vibrant touchscreen.")
                    .price(1499F)
                    .discountPercentage(10)
                    .rating(4.43F)
                    .stock(68)
                    .thumbnail("https://i.dummyjson.com/data/products/8/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/8/1.jpg",
                            "https://i.dummyjson.com/data/products/8/2.jpg",
                            "https://i.dummyjson.com/data/products/8/3.jpg",
                            "https://i.dummyjson.com/data/products/8/4.jpg",
                            "https://i.dummyjson.com/data/products/8/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(3)
                            .name("Laptops")
                            .build())
                    .brand(Brand.builder()
                            .id(5)
                            .name("Microsoft Surface")
                            .build())
                    .build();

            Product infinix_inbook = Product.builder()
                    .id(9)
                    .title("Infinix INBOOK")
                    .description("Infinix Inbook X1 Ci3 10th 8GB 256GB 14 Win10 Grey – 1 Year Warranty")
                    .price(1099F)
                    .discountPercentage(11)
                    .rating(4.54F)
                    .stock(96)
                    .thumbnail("https://i.dummyjson.com/data/products/9/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/9/1.jpg",
                            "https://i.dummyjson.com/data/products/9/2.png",
                            "https://i.dummyjson.com/data/products/9/3.png",
                            "https://i.dummyjson.com/data/products/9/4.jpg",
                            "https://i.dummyjson.com/data/products/9/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(3)
                            .name("Laptops")
                            .build())
                    .brand(Brand.builder()
                            .id(6)
                            .name("Infinix")
                            .build())
                    .build();

            Product hp_pavillon_15 = Product.builder()
                    .id(10)
                    .title("HP Pavilion 15-DK1056WM")
                    .description("HP Pavilion 15-DK1056WM Gaming Laptop 10th Gen Core i5, 8GB, 256GB SSD, GTX 1650 4GB, Windows 10")
                    .price(1099F)
                    .discountPercentage(6)
                    .rating(4.43F)
                    .stock(89)
                    .thumbnail("https://i.dummyjson.com/data/products/10/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/10/1.jpg",
                            "https://i.dummyjson.com/data/products/10/2.jpg",
                            "https://i.dummyjson.com/data/products/10/3.jpg",
                            "https://i.dummyjson.com/data/products/10/thumbnail.jpeg")))
                    .category(Category.builder()
                            .id(3)
                            .name("Laptops")
                            .build())
                    .brand(Brand.builder()
                            .id(7)
                            .name("HP Pavilion")
                            .build())
                    .build();

            Product perfume_oil = Product.builder()
                    .id(11)
                    .title("Perfume Oil")
                    .description("Mega Discount, Impression of Acqua Di Gio by GiorgioArmani concentrated attar perfume Oil")
                    .price(13F)
                    .discountPercentage(8)
                    .rating(4.26F)
                    .stock(65)
                    .thumbnail("https://i.dummyjson.com/data/products/11/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/11/1.jpg",
                            "https://i.dummyjson.com/data/products/11/2.jpg",
                            "https://i.dummyjson.com/data/products/11/3.jpg",
                            "https://i.dummyjson.com/data/products/11/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(2)
                            .name("Fragrances")
                            .build())
                    .brand(Brand.builder()
                            .id(8)
                            .name("Impression of Acqua Di Gio")
                            .build())
                    .build();

            Product brown_perfume = Product.builder()
                    .id(12)
                    .title("Brown Perfume")
                    .description("Royal_Mirage Sport Brown Perfume for Men & Women - 120ml")
                    .price(40F)
                    .discountPercentage(16)
                    .rating(4F)
                    .stock(52)
                    .thumbnail("https://i.dummyjson.com/data/products/12/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/12/1.jpg",
                            "https://i.dummyjson.com/data/products/12/2.jpg",
                            "https://i.dummyjson.com/data/products/12/3.png",
                            "https://i.dummyjson.com/data/products/12/4.jpg",
                            "https://i.dummyjson.com/data/products/12/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(2)
                            .name("Fragrances")
                            .build())
                    .brand(Brand.builder()
                            .id(9)
                            .name("Royal_Mirage")
                            .build())
                    .build();

            Product fog_scent_xpressio_perfume = Product.builder()
                    .id(13)
                    .title("Fog Scent Xpressio Perfume")
                    .description("Product details of Best Fog Scent Xpressio Perfume 100ml For Men cool long lasting perfumes for Men")
                    .price(13F)
                    .discountPercentage(8)
                    .rating(4.59F)
                    .stock(61)
                    .thumbnail("https://i.dummyjson.com/data/products/13/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/13/1.jpg",
                            "https://i.dummyjson.com/data/products/13/2.png",
                            "https://i.dummyjson.com/data/products/13/3.jpg",
                            "https://i.dummyjson.com/data/products/13/4.jpg",
                            "https://i.dummyjson.com/data/products/13/thumbnail.webp")))
                    .category(Category.builder()
                            .id(2)
                            .name("Fragrances")
                            .build())
                    .brand(Brand.builder()
                            .id(10)
                            .name("Fog Scent Xpressio")
                            .build())
                    .build();

            Product non_alcoholic_perfume = Product.builder()
                    .id(14)
                    .title("Non-Alcoholic Concentrated Perfume Oil")
                    .description("Original Al Munakh® by Mahal Al Musk | Our Impression of Climate | 6ml Non-Alcoholic Concentrated Perfume Oil")
                    .price(120F)
                    .discountPercentage(16)
                    .rating(4.21F)
                    .stock(114)
                    .thumbnail("https://i.dummyjson.com/data/products/14/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/14/1.jpg",
                            "https://i.dummyjson.com/data/products/14/2.jpg",
                            "https://i.dummyjson.com/data/products/14/3.jpg",
                            "https://i.dummyjson.com/data/products/14/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(2)
                            .name("Fragrances")
                            .build())
                    .brand(Brand.builder()
                            .id(11)
                            .name("Al Munakh")
                            .build())
                    .build();

            Product eau_de_perfume_spray = Product.builder()
                    .id(15)
                    .title("Eau De Perfume Spray")
                    .description("Genuine  Al-Rehab spray perfume from UAE/Saudi Arabia/Yemen High Quality")
                    .price(30F)
                    .discountPercentage(11)
                    .rating(4.7F)
                    .stock(105)
                    .thumbnail("https://i.dummyjson.com/data/products/15/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/15/1.jpg",
                            "https://i.dummyjson.com/data/products/15/2.jpg",
                            "https://i.dummyjson.com/data/products/15/3.jpg",
                            "https://i.dummyjson.com/data/products/15/4.jpg",
                            "https://i.dummyjson.com/data/products/15/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(2)
                            .name("Fragrances")
                            .build())
                    .brand(Brand.builder()
                            .id(12)
                            .name("Lord - Al-Rehab")
                            .build())
                    .build();

            Product hyaluronic_acid_serum = Product.builder()
                    .id(16)
                    .title("Hyaluronic Acid Serum")
                    .description("L'Oréal Paris introduces Hyaluron Expert Replumping Serum formulated with 1.5% Hyaluronic Acid")
                    .price(19F)
                    .discountPercentage(13)
                    .rating(4.83F)
                    .stock(110)
                    .thumbnail("https://i.dummyjson.com/data/products/16/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/16/1.png",
                            "https://i.dummyjson.com/data/products/16/2.webp",
                            "https://i.dummyjson.com/data/products/16/3.jpg",
                            "https://i.dummyjson.com/data/products/16/4.jpg",
                            "https://i.dummyjson.com/data/products/16/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(4)
                            .name("Skincare")
                            .build())
                    .brand(Brand.builder()
                            .id(13)
                            .name("L'Oreal Paris")
                            .build())
                    .build();

            Product tree_oil = Product.builder()
                    .id(17)
                    .title("Tree Oil 30ml")
                    .description("Tea tree oil contains a number of compounds, including terpinen-4-ol, that have been shown to kill certain bacteria")
                    .price(12F)
                    .discountPercentage(4)
                    .rating(4.52F)
                    .stock(78)
                    .thumbnail("https://i.dummyjson.com/data/products/17/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/17/1.jpg",
                            "https://i.dummyjson.com/data/products/17/2.jpg",
                            "https://i.dummyjson.com/data/products/17/3.jpg",
                            "https://i.dummyjson.com/data/products/17/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(4)
                            .name("Skincare")
                            .build())
                    .brand(Brand.builder()
                            .id(14)
                            .name("Hemani Tea")
                            .build())
                    .build();

            Product oil_free_moisturizer = Product.builder()
                    .id(18)
                    .title("Oil Free Moisturizer 100ml")
                    .description("Dermive Oil Free Moisturizer with SPF 20 is specifically formulated with ceramides, hyaluronic acid & sunscreen.")
                    .price(40F)
                    .discountPercentage(13)
                    .rating(4.56F)
                    .stock(88)
                    .thumbnail("https://i.dummyjson.com/data/products/18/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/18/1.jpg",
                            "https://i.dummyjson.com/data/products/18/2.jpg",
                            "https://i.dummyjson.com/data/products/18/3.jpg",
                            "https://i.dummyjson.com/data/products/18/4.jpg",
                            "https://i.dummyjson.com/data/products/18/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(4)
                            .name("Skincare")
                            .build())
                    .brand(Brand.builder()
                            .id(15)
                            .name("Dermive")
                            .build())
                    .build();

            Product skin_beauty_serum = Product.builder()
                    .id(19)
                    .title("Skin Beauty Serum")
                    .description("Product name: rorec collagen hyaluronic acid white face serum riceNet weight: 15 m")
                    .price(46F)
                    .discountPercentage(11)
                    .rating(4.42F)
                    .stock(54)
                    .thumbnail("https://i.dummyjson.com/data/products/19/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/19/1.jpg",
                            "https://i.dummyjson.com/data/products/19/2.jpg",
                            "https://i.dummyjson.com/data/products/19/3.png",
                            "https://i.dummyjson.com/data/products/19/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(4)
                            .name("Skincare")
                            .build())
                    .brand(Brand.builder()
                            .id(16)
                            .name("ROREC White Rice")
                            .build())
                    .build();

            Product freckle_treatment = Product.builder()
                    .id(20)
                    .title("Freckle Treatment Cream- 15gm")
                    .description("Fair & Clear is Pakistan's only pure Freckle cream which helpsfade Freckles, Darkspots and pigments. Mercury level is 0%, so there are no side effects.")
                    .price(70F)
                    .discountPercentage(17)
                    .rating(4.06F)
                    .stock(140)
                    .thumbnail("https://i.dummyjson.com/data/products/20/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/20/1.jpg",
                            "https://i.dummyjson.com/data/products/20/2.jpg",
                            "https://i.dummyjson.com/data/products/20/3.jpg",
                            "https://i.dummyjson.com/data/products/20/4.jpg",
                            "https://i.dummyjson.com/data/products/20/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(4)
                            .name("Skincare")
                            .build())
                    .brand(Brand.builder()
                            .id(17)
                            .name("Fair & Clear")
                            .build())
                    .build();

            Product daal_masoor = Product.builder()
                    .id(21)
                    .title("Daal Masoor 500 grams")
                    .description("Fine quality Branded Product Keep in a cool and dry place")
                    .price(20F)
                    .discountPercentage(5)
                    .rating(4.44F)
                    .stock(133)
                    .thumbnail("https://i.dummyjson.com/data/products/21/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/21/1.png",
                            "https://i.dummyjson.com/data/products/21/2.jpg",
                            "https://i.dummyjson.com/data/products/21/3.jpg")))
                    .category(Category.builder()
                            .id(5)
                            .name("Groceries")
                            .build())
                    .brand(Brand.builder()
                            .id(18)
                            .name("Saaf & Khaas")
                            .build())
                    .build();

            Product elbow_macaroni = Product.builder()
                    .id(22)
                    .title("Elbow Macaroni - 400 gm")
                    .description("Product details of Bake Parlor Big Elbow Macaroni - 400 gm")
                    .price(14F)
                    .discountPercentage(16)
                    .rating(4.57F)
                    .stock(146)
                    .thumbnail("https://i.dummyjson.com/data/products/22/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/22/1.jpg",
                            "https://i.dummyjson.com/data/products/22/2.jpg",
                            "https://i.dummyjson.com/data/products/22/3.jpg")))
                    .category(Category.builder()
                            .id(5)
                            .name("Groceries")
                            .build())
                    .brand(Brand.builder()
                            .id(19)
                            .name("Bake Parlor Big")
                            .build())
                    .build();

            Product orange_essence = Product.builder()
                    .id(23)
                    .title("Orange Essence Food Flavou")
                    .description("Specifications of Orange Essence Food Flavour For Cakes and Baking Food Item")
                    .price(14F)
                    .discountPercentage(8)
                    .rating(4.85F)
                    .stock(26)
                    .thumbnail("https://i.dummyjson.com/data/products/23/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/23/1.jpg",
                            "https://i.dummyjson.com/data/products/23/2.jpg",
                            "https://i.dummyjson.com/data/products/23/3.jpg",
                            "https://i.dummyjson.com/data/products/23/4.jpg",
                            "https://i.dummyjson.com/data/products/23/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(5)
                            .name("Groceries")
                            .build())
                    .brand(Brand.builder()
                            .id(20)
                            .name("Baking Food Items")
                            .build())
                    .build();

            Product cerals_muesli = Product.builder()
                    .id(24)
                    .title("cereals muesli fruit nuts")
                    .description("original fauji cereal muesli 250gm box pack original fauji cereals muesli fruit nuts flakes breakfast cereal break fast faujicereals cerels cerel foji fouji")
                    .price(46F)
                    .discountPercentage(17)
                    .rating(4.94F)
                    .stock(113)
                    .thumbnail("https://i.dummyjson.com/data/products/24/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/24/1.jpg",
                            "https://i.dummyjson.com/data/products/24/2.jpg",
                            "https://i.dummyjson.com/data/products/24/3.jpg",
                            "https://i.dummyjson.com/data/products/24/4.jpg",
                            "https://i.dummyjson.com/data/products/24/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(5)
                            .name("Groceries")
                            .build())
                    .brand(Brand.builder()
                            .id(21)
                            .name("fauji")
                            .build())
                    .build();

            Product gulab_powder = Product.builder()
                    .id(25)
                    .title("Gulab Powder 50 Gram")
                    .description("Dry Rose Flower Powder Gulab Powder 50 Gram • Treats Wounds")
                    .price(70F)
                    .discountPercentage(14)
                    .rating(4.87F)
                    .stock(47)
                    .thumbnail("https://i.dummyjson.com/data/products/25/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/25/1.png",
                            "https://i.dummyjson.com/data/products/25/2.jpg",
                            "https://i.dummyjson.com/data/products/25/3.png",
                            "https://i.dummyjson.com/data/products/25/4.jpg",
                            "https://i.dummyjson.com/data/products/25/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(5)
                            .name("Groceries")
                            .build())
                    .brand(Brand.builder()
                            .id(22)
                            .name("Dry Rose")
                            .build())
                    .build();

            Product plant_hanger = Product.builder()
                    .id(26)
                    .title("Plant Hanger For Home")
                    .description("Boho Decor Plant Hanger For Home Wall Decoration Macrame Wall Hanging Shelf")
                    .price(41F)
                    .discountPercentage(18)
                    .rating(4.08F)
                    .stock(131)
                    .thumbnail("https://i.dummyjson.com/data/products/26/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/26/1.jpg",
                            "https://i.dummyjson.com/data/products/26/2.jpg",
                            "https://i.dummyjson.com/data/products/26/3.jpg",
                            "https://i.dummyjson.com/data/products/26/4.jpg",
                            "https://i.dummyjson.com/data/products/26/5.jpg",
                            "https://i.dummyjson.com/data/products/26/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(6)
                            .name("Home-decoration")
                            .build())
                    .brand(Brand.builder()
                            .id(23)
                            .name("Boho Decor")
                            .build())
                    .build();

            Product flying_wooden = Product.builder()
                    .id(27)
                    .title("Flying Wooden Bird")
                    .description("Package Include 6 Birds with Adhesive Tape Shape: 3D Shaped Wooden Birds Material: Wooden MDF, Laminated 3.5mm")
                    .price(51F)
                    .discountPercentage(16)
                    .rating(4.41F)
                    .stock(17)
                    .thumbnail("https://i.dummyjson.com/data/products/27/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/27/1.jpg",
                            "https://i.dummyjson.com/data/products/27/2.jpg",
                            "https://i.dummyjson.com/data/products/27/3.jpg",
                            "https://i.dummyjson.com/data/products/27/4.jpg",
                            "https://i.dummyjson.com/data/products/27/thumbnail.webp")))
                    .category(Category.builder()
                            .id(6)
                            .name("Home-decoration")
                            .build())
                    .brand(Brand.builder()
                            .id(24)
                            .name("Flying Wooden")
                            .build())
                    .build();

            Product embellishment = Product.builder()
                    .id(28)
                    .title("3D Embellishment Art Lamp")
                    .description("3D led lamp sticker Wall sticker 3d wall art light on/off button  cell operated (included)")
                    .price(20F)
                    .discountPercentage(16)
                    .rating(4.82F)
                    .stock(54)
                    .thumbnail("https://i.dummyjson.com/data/products/28/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/28/1.jpg",
                            "https://i.dummyjson.com/data/products/28/2.jpg",
                            "https://i.dummyjson.com/data/products/28/3.png",
                            "https://i.dummyjson.com/data/products/28/4.jpg",
                            "https://i.dummyjson.com/data/products/28/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(6)
                            .name("Home-decoration")
                            .build())
                    .brand(Brand.builder()
                            .id(25)
                            .name("LED Lights")
                            .build())
                    .build();

            Product handcraft = Product.builder()
                    .id(29)
                    .title("Handcraft Chinese style")
                    .description("Handcraft Chinese style art luxury palace hotel villa mansion home decor ceramic vase with brass fruit plate")
                    .price(60F)
                    .discountPercentage(15)
                    .rating(4.44F)
                    .stock(7)
                    .thumbnail("https://i.dummyjson.com/data/products/29/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/29/1.jpg",
                            "https://i.dummyjson.com/data/products/29/2.jpg",
                            "https://i.dummyjson.com/data/products/29/3.webp",
                            "https://i.dummyjson.com/data/products/29/4.webp",
                            "https://i.dummyjson.com/data/products/29/thumbnail.webp")))
                    .category(Category.builder()
                            .id(6)
                            .name("Home-decoration")
                            .build())
                    .brand(Brand.builder()
                            .id(26)
                            .name("Luxury palace")
                            .build())
                    .build();

            Product key_holder = Product.builder()
                    .id(30)
                    .title("Key Holder")
                    .description("Attractive DesignMetallic materialFour key hooksReliable & DurablePremium Quality")
                    .price(30F)
                    .discountPercentage(3)
                    .rating(4.92F)
                    .stock(54)
                    .thumbnail("https://i.dummyjson.com/data/products/30/thumbnail.jpg")
                    .images(new HashSet<>(Arrays.asList(
                            "https://i.dummyjson.com/data/products/30/1.jpg",
                            "https://i.dummyjson.com/data/products/30/2.jpg",
                            "https://i.dummyjson.com/data/products/30/3.jpg",
                            "https://i.dummyjson.com/data/products/30/thumbnail.jpg")))
                    .category(Category.builder()
                            .id(6)
                            .name("Home-decoration")
                            .build())
                    .brand(Brand.builder()
                            .id(27)
                            .name("Golden")
                            .build())
                    .build();

            productRepository.saveAll(Arrays.asList(iphone_9, iphone_x, samsung_universe_9, oppo_f_19, huawei_p_30,
                    mac_book_pro, samsung_galaxy_book, microsoft_surface_laptop_4, infinix_inbook, hp_pavillon_15,
                    perfume_oil, brown_perfume, fog_scent_xpressio_perfume, non_alcoholic_perfume, eau_de_perfume_spray,
                    hyaluronic_acid_serum, tree_oil, oil_free_moisturizer, skin_beauty_serum, freckle_treatment,
                    daal_masoor, elbow_macaroni, orange_essence, cerals_muesli, gulab_powder, plant_hanger,
                    flying_wooden, embellishment, handcraft, key_holder));
        }
    }
}
