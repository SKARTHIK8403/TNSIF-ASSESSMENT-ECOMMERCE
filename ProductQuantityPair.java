package com.vemana.ecommerce;



public class ProductQuantityPair {
    private Product product;
    private int quantity;

    public ProductQuantityPair(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public String toString() {
        return product.getName() + " x " + quantity;
    }
}

