package com.marcellus.restangularserver.repository.files;

import java.io.IOException;
import java.util.List;

public interface ProductRepository {

    List<String> getAllProducts() throws IOException;
}
