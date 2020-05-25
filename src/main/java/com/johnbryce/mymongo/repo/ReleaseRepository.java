package com.johnbryce.mymongo.repo;

import com.johnbryce.mymongo.model.Release;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReleaseRepository extends MongoRepository<Release,String> {
}
