package com.vemana.ecommerce;

import java.util.Map;

public class ProductService {
    private Map<Integer, Product> products;

    public ProductService(Map<Integer, Product> products) {
        this.products = products;
    }

    public Product getProduct(int id) {
        return products.get(id);
    }

    public void viewAllProducts() {
        for (Product p : products.values()) System.out.println(p);
    }
}

