package com.vemana.ecommerce;



import java.util.*;

public class ShoppingCart {
    private Map<Product, Integer> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public void addItem(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public Map<Product, Integer> getItems() { return items; }

    public void clear() { items.clear(); }

    public String toString() {
        if (items.isEmpty()) return "Cart is empty.";
        StringBuilder sb = new StringBuilder("Shopping Cart:\n");
        for (Map.Entry<Product, Integer> e : items.entrySet()) {
            sb.append("- ").append(e.getKey().getName()).append(" x ").append(e.getValue()).append("\n");
        }
        return sb.toString();
    }
}

