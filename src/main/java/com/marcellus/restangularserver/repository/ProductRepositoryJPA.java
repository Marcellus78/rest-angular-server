package com.marcellus.restangularserver.repository;

import com.marcellus.restangularserver.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryJPA extends JpaRepository<Product, Integer>, ProductRepositoryCustom {

}
