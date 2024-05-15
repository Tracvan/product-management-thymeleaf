package com.codegym.productmanagementthymeleaf.service;

import com.codegym.productmanagementthymeleaf.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService{
    private static final Map<Integer,Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Apple", 5.0, "fruit"));
        products.put(2, new Product(2, "Orange", 3.0, "fruit"));
        products.put(3, new Product(3, "Banana", 2.0, "fruit"));
        products.put(4, new Product(4, "Coconut", 3.0, "fruit"));
        products.put(5, new Product(5, "Kiwi", 6.0, "fruit"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
