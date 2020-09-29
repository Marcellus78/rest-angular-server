package com.marcellus.restangularserver.service;

import com.marcellus.restangularserver.model.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<Product> allProducts() throws IOException;
    Product productById(Long id) throws IOException;
    void saveProduct(Product product);
}
