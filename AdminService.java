package com.vemana.ecommerce;

import java.util.*;

public class AdminService {
    private Map<Integer, Product> products;

    public AdminService(Map<Integer, Product> products) {
        this.products = products;
    }

    public void addProduct(int id, String name, double price, int stock) {
        products.put(id, new Product(id, name, price, stock));
    }

    public void removeProduct(int id) {
        products.remove(id);
    }

    public void updateProductStock(int id, int stock) {
        Product p = products.get(id);
        if (p != null) p.increaseStock(stock);
    }

    public void viewProducts() {
        for (Product p : products.values()) System.out.println(p);
    }
}

