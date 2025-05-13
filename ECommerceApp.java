package com.vemana.ecommerce;
import java.util.*;

public class ECommerceApp {
    private static final Scanner sc = new Scanner(System.in);
    private static final Map<Integer, Product> products = new HashMap<>();
    private static final Map<Integer, Customer> customers = new HashMap<>();
    private static final Map<Integer, Admin> admins = new HashMap<>();
    private static final List<Order> orders = new ArrayList<>();

    private static final AdminService adminService = new AdminService(products);
    private static final CustomerService customerService = new CustomerService(customers);
    private static final ProductService productService = new ProductService(products);
    private static final OrderService orderService = new OrderService(orders);

    public static void main(String[] args) {
        // Add a default admin
        admins.put(1, new Admin(1, "admin", "admin@shop.com"));

        while (true) {
            System.out.println("\n1. Admin Menu\n2. Customer Menu\n3. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: adminMenu();
                case 2: customerMenu();
                case 3: {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
            }
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Product\n2. Remove Product\n3. View Products\n4. Update Order Status\n5. View Orders\n6. Return");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:{
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter Stock Quantity: ");
                    int stock = sc.nextInt();
                    adminService.addProduct(id, name, price, stock);
                    System.out.println("Product added successfully!");
                }
                case 2:{
                    System.out.print("Enter Product ID to remove: ");
                    int id = sc.nextInt();
                    adminService.removeProduct(id);
                    System.out.println("Product removed if it existed.");
                }
                case 3: adminService.viewProducts();
                case 4:{
                    System.out.print("Enter Order ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new status (Completed/Delivered/Cancelled): ");
                    String status = sc.nextLine();
                    orderService.updateOrderStatus(id, status);
                }
                case 5: orderService.viewAllOrders();
                case 6: { return; }
            }
        }
    }

    private static void customerMenu() {
        Customer customer = null;
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Register\n2. View Products\n3. Add to Cart\n4. View Cart\n5. Place Order\n6. View Orders\n7. Return");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.print("Enter Customer ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Username: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();
                    customer = customerService.createCustomer(id, name, email, address);
                    System.out.println("Customer registered!");
                }
                case 2: productService.viewAllProducts();
                case 3: {
                    if (customer == null) {
                        System.out.println("Please register first.");
                        break;
                    }
                    System.out.print("Enter Product ID: ");
                    int pid = sc.nextInt();
                    Product product = productService.getProduct(pid);
                    if (product == null) {
                        System.out.println("Product not found.");
                        break;
                    }
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    if (qty > product.getStockQuantity()) {
                        System.out.println("Insufficient stock.");
                        break;
                    }
                    customer.getCart().addItem(product, qty);
                    product.reduceStock(qty);
                    System.out.println("Added to cart.");
                }
                case 4:{
                    if (customer != null) System.out.println(customer.getCart());
                    else System.out.println("Please register first.");
                }
                case 5:{
                    if (customer != null) orderService.placeOrder(customer);
                    else System.out.println("Please register first.");
                }
                case 6: {
                    if (customer != null) orderService.viewOrders(customer);
                    else System.out.println("Please register first.");
                }
                case 7:{ return; }
            }
        }
    }
}

