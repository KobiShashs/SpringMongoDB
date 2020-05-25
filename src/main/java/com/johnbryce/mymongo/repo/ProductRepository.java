package com.johnbryce.mymongo.repo;

import com.johnbryce.mymongo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {

    List<Product> findByName(String name);
}
