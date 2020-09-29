package com.marcellus.restangularserver.repository;

import com.marcellus.restangularserver.mapper.ProductMapper;
import com.marcellus.restangularserver.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {


    private final ProductMapper mapper;

    public ProductRepositoryCustomImpl(ProductMapper mapper) {
        this.mapper = mapper;
    }

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<String> getAllProducts() {

        String sqlQuery = "select * from product";

        List<Product> productsList = entityManager
                .createNativeQuery(sqlQuery, Product.class).getResultList();

        List<String> productListString = productsList.stream()
                .map(data -> mapper.productToString(data))
                .collect(Collectors.toList());

        return productListString;
    }
}
