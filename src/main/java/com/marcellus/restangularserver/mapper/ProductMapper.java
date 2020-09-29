package com.marcellus.restangularserver.mapper;

import com.marcellus.restangularserver.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product stringToProduct(String data) {

        Product product = new Product();

        String[] splintedData = data.split(", ");

        product.setId(Long.valueOf(splintedData[0]));
        product.setName(splintedData[1]);
        product.setPrice(Double.valueOf(splintedData[2]));

        return product;
    }

    public String productToString(Product product) {

        StringBuilder productString =  new StringBuilder();

        productString.append(product.getId()).append(", ")
                .append(product.getName()).append(", ")
                .append(product.getPrice());

        return productString.toString();
    }
}
