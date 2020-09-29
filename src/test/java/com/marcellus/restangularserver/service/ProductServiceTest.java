package com.marcellus.restangularserver.service;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.marcellus.restangularserver.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {



    @Test
    void splitDataTest() throws IOException{

        File file = ResourceUtils.getFile("classpath:static/products.txt");
        List<String> result = Files.readLines(file, Charsets.UTF_8);

        String[] splintedData = result.get(0).split(", ");

        assertEquals(splintedData.length,3);
    }

}