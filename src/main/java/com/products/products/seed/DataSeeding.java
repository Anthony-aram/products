package com.products.products.seed;

import com.products.products.entity.Category;
import com.products.products.entity.Product;
import com.products.products.repository.CategoryRepository;
import com.products.products.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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
            Product iphone14 = Product.builder()
                    .id(1)
                    .title("Iphone 14 Pro Max")
                    .description("Votre photo. Votre typo. Vos widgets. Votre iPhone. Avec iOS 16, vous pouvez personnaliser votre écran verrouillé de façons inédites. Détourez une partie de votre photo pour la mettre en avant. Suivez l’évolution de vos anneaux Activité. Et voyez en direct les informations de vos apps préférées.")
                    .price(1379F)
                    .rating(4F)
                    .stock(50)
                    .discountPercentage(8F)
                    .category(Category.builder()
                            .id(1)
                            .name("Téléphone")
                            .build())
                    .build();
            Product macBook = Product.builder()
                    .id(2)
                    .title("MacBook Air 13\"")
                    .description("MacBook Air : Il y a de la puissance dans l’air. Notre portable le plus fin et le plus léger est métamorphosé par la puce Apple M1. Avec des performances de processeur jusqu’à 3,5 fois plus élevées. Un processeur graphique jusqu’à 5 fois plus rapide. Une vitesse d’apprentissage automatique jusqu’à 9 fois supérieure grâce à notre Neural Engine le plus avancé. Une autonomie record sur MacBook Air. Et un design silencieux, sans ventilateur. C’est un véritable poids lourd de puissance, dans un format toujours aussi léger.")
                    .price(1199F)
                    .rating(4.5F)
                    .stock(67)
                    .category(Category.builder()
                            .id(3)
                            .name("Laptop")
                            .build())
                    .build();
            Product ipad = Product.builder()
                    .id(3)
                    .title("Apple iPad")
                    .description("Le tout dernier iPad tout en couleur se réinvente pour être plus performant, plus intuitif et encore plus fun. Avec son nouvel écran bord à bord Liquid Retina de 10,9 pouces et quatre superbes finitions, il vous permet d’en faire plus, de garder le contact et de donner libre cours à votre créativité. Et grâce aux accessoires conçus spécialement pour lui, les possibilités sont infinies. Dessinez, peignez et écrivez avec l’Apple Pencil. Et profitez d’un clavier complet et d’un trackpad entièrement cliqua\u00AD\u00ADble avec le Magic Keyboard Folio. Grâce à son design modulaire en deux parties, vous pouvez visionner vos contenus et utiliser les raccourcis que vous connaissez déjà, tout en bénéficiant d’un confort de frappe exceptionnel. iPadOS est au cœur de l’expérience iPad. Grâce à lui, tout est simple et parfaitement fluide. Vous pouvez utiliser vos apps côte à côte, retoucher et partager vos photos, ou encore accéder à tous vos fichiers.")
                    .price(589.99F)
                    .rating(5F)
                    .stock(1)
                    .category(Category.builder()
                            .id(2)
                            .name("Tablet")
                            .build())
                    .build();

            productRepository.saveAll(Arrays.asList(iphone14, macBook, ipad));
        }
    }
}
