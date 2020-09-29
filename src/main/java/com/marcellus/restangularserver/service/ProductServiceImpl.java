package com.marcellus.restangularserver.service;

import com.marcellus.restangularserver.mapper.ProductMapper;
import com.marcellus.restangularserver.model.Product;
import com.marcellus.restangularserver.repository.ProductRepositoryJPA;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepositoryJPA productRepository;
    private final ProductMapper mapper;

    public ProductServiceImpl(ProductRepositoryJPA productRepository,
                              ProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Product> allProducts() throws IOException {

        List<Product> products = productRepository
                .getAllProducts()
                .stream()
                .map(data -> mapper.stringToProduct(data))
                .collect(Collectors.toList());
        return products;
    }

    @Override
    public Product productById(Long id) throws IOException {

        Product product = productRepository
                .getAllProducts()
                .stream()
                .map(data -> mapper.stringToProduct(data))
                .filter(tempProduct -> tempProduct.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product not found"));

        return product;
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
