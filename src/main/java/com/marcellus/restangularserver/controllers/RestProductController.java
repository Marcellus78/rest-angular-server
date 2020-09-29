package com.marcellus.restangularserver.controllers;

import com.marcellus.restangularserver.model.Product;
import com.marcellus.restangularserver.service.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class RestProductController {

    private final ProductServiceImpl productService;

    public RestProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public List<Product> getAllProducts() throws IOException {

        return productService.allProducts();
    }
    @GetMapping("/api/products/{id}")
    public Product getProductById(@PathVariable String id) throws IOException {

        return productService.productById(Long.valueOf(id));
    }
    @PostMapping("/api/products/")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(@RequestBody Product product) {

        productService.saveProduct(product);
    }
}
