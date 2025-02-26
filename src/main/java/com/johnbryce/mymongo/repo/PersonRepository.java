package com.johnbryce.mymongo.repo;

import com.johnbryce.mymongo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends MongoRepository<Person, Long>{
    List<Person> findByLastName(@Param("name") String name);
}