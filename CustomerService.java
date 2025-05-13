package com.vemana.ecommerce;

import java.util.*;

public class CustomerService {
    private Map<Integer, Customer> customers;

    public CustomerService(Map<Integer, Customer> customers) {
        this.customers = customers;
    }

    public Customer createCustomer(int id, String name, String email, String address) {
        Customer c = new Customer(id, name, email, address);
        customers.put(id, c);
        return c;
    }

    public Customer getCustomer(int id) {
        return customers.get(id);
    }
}

