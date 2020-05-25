package com.johnbryce.mymongo.repo;

import com.johnbryce.mymongo.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {
    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
}