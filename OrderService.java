package com.vemana.ecommerce;

import java.util.List;

public class OrderService {
    private List<Order> orders;

    public OrderService(List<Order> orders) {
        this.orders = orders;
    }

    public void placeOrder(Customer customer) {
        if (customer.getCart().getItems().isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }
        Order order = new Order(customer, customer.getCart().getItems());
        orders.add(order);
        customer.addOrder(order);
        customer.getCart().clear();
        System.out.println("Order placed successfully! Order ID: " + order.getOrderId());
    }

    public void viewOrders(Customer customer) {
        for (Order o : customer.getOrders()) System.out.println(o);
    }

    public void updateOrderStatus(int orderId, String status) {
        for (Order o : orders) {
            if (o.getOrderId() == orderId) {
                o.setStatus(status);
                return;
            }
        }
        System.out.println("Order not found!");
    }

    public void viewAllOrders() {
        for (Order o : orders) System.out.println(o);
    }
}

