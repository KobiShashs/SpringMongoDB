package com.johnbryce.mymongo.repo;

import com.johnbryce.mymongo.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.stream.Stream;

public interface TicketRepository extends MongoRepository<Ticket, String> {

    @Query("{ 'status' : ?0}")
    Stream<Ticket> findAllByCustomQueryAndStream(String status);

    List<Ticket> findByStatus(String status);
    List<Ticket> findByTitle(String title);
    List<Ticket> findByAppId(String appId); // Now It indexed by annotation in th model

}
