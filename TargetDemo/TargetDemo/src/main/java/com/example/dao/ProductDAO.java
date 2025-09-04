package com.example.dao;

import com.example.model.Product;
import java.util.*;

public class ProductDAO {
    // Singleton so all servlets see the same data
    private static final ProductDAO INSTANCE = new ProductDAO();
    public static ProductDAO getInstance() { return INSTANCE; }

    private final List<Product> products = Collections.synchronizedList(new ArrayList<>());
    private int currentId = 1;

    private ProductDAO() {
        // Seed with a sample product
        addProduct(new Product(0, "Sample Item", 9.99));
    }

    public synchronized void addProduct(Product p) {
        p.setId(currentId++);
        products.add(p);
    }

    public List<Product> getAll() {
        return new ArrayList<>(products);
    }

    public Product getById(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public synchronized void update(Product updated) {
        for (Product p : products) {
            if (p.getId() == updated.getId()) {
                p.setName(updated.getName());
                p.setPrice(updated.getPrice());
                return;
            }
        }
    }

    public synchronized void delete(int id) {
        products.removeIf(p -> p.getId() == id);
    }
}
