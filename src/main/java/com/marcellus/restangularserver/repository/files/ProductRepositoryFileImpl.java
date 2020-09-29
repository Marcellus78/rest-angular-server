package com.marcellus.restangularserver.repository.files;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class ProductRepositoryFileImpl implements ProductRepository {


    @Override
    public List<String> getAllProducts() throws IOException {

        Resource resource = new ClassPathResource("static/products.txt");

        File file = resource.getFile();
        List<String> result = Files.readLines(file, Charsets.UTF_8);

        return result;
    }
}
