package com.products.products.specification.metaModel;

import com.products.products.entity.Product;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Product.class)
public abstract class Product_ {
    public static volatile SingularAttribute<Product, String> title;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Float> price;
    public static volatile SingularAttribute<Product, Integer> discountPercentage;
    public static volatile SingularAttribute<Product, Float> rating;
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String PRICE = "price";
    public static final String DISCOUNT_PERCENTAGE = "discountPercentage";
    public static final String RATING = "rating";

    public Product_() {
    }
}
