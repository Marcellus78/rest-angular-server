package com.marcellus.restangularserver.bootstrap;

import com.marcellus.restangularserver.model.Product;
import com.marcellus.restangularserver.repository.ProductRepositoryJPA;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepositoryJPA productRepositoryJPA;

    public DataLoader(ProductRepositoryJPA productRepositoryJPA) {
        this.productRepositoryJPA = productRepositoryJPA;
    }

    @Override
    public void run(String... args) throws Exception {
        loadProducts();
    }
    private void loadProducts() {
        Product product0 = Product.builder().id(1L).name("First Product").price(24.99).build();
        Product product1 = Product.builder().id(2L).name("Second Product").price(64.99).build();
        Product product2 = Product.builder().id(3L).name("Third Product").price(74.99).build();

        productRepositoryJPA.saveAll(Arrays.asList(product0, product1, product2));
        System.out.println("Loaded products " + productRepositoryJPA.count());

    }
}
