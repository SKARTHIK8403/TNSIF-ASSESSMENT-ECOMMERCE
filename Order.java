package com.vemana.ecommerce;



import java.util.*;

public class Order {
    private static int idCounter = 1;
    private int orderId;
    private Customer customer;
    private List<ProductQuantityPair> items;
    private String status;

    public Order(Customer customer, Map<Product, Integer> cartItems) {
        this.orderId = idCounter++;
        this.customer = customer;
        this.items = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            items.add(new ProductQuantityPair(entry.getKey(), entry.getValue()));
        }
        this.status = "Pending";
    }

    public int getOrderId() { return orderId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String toString() {
        StringBuilder sb = new StringBuilder("Order ID: " + orderId + ", Status: " + status + "\n");
        for (ProductQuantityPair pair : items) {
            sb.append("  ").append(pair).append("\n");
        }
        return sb.toString();
    }
}

