package com.johnbryce.mymongo.repo;

import com.johnbryce.mymongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,Integer> {
}
