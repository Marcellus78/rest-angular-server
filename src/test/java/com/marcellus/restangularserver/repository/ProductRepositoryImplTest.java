package com.marcellus.restangularserver.repository;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryImplTest {

    @Test
    void readUsingFileFromResource() throws IOException {

        File file = ResourceUtils.getFile("classpath:static/products.txt");
        List<String> result = Files.readLines(file, Charsets.UTF_8);

        assertEquals(result.stream().count(), 3L );
    }

}