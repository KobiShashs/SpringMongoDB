package com.johnbryce.mymongo.clr;

import com.johnbryce.mymongo.model.Product;
import com.johnbryce.mymongo.model.Release;
import com.johnbryce.mymongo.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

//@Component
public class ProductWithTemplateCLR implements CommandLineRunner {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception {
        mongoTemplate.getCollection("product").drop();
        Product product1 = new Product(UUID.randomUUID().toString(),"Android","Playstudios Android App","Chen");
        Product product2 = new Product(UUID.randomUUID().toString(),"iOS","Playstudios iOS App","Noy");
        Product product3 = new Product(UUID.randomUUID().toString(),"Backend","Playstudios Android App","Tom");

        mongoTemplate.insert(product1);
        mongoTemplate.insert(product2);
        mongoTemplate.insert(product3);

        Ticket ticket1 = Ticket.builder().title("Splash screen").appId(product1.getId()).status("open").description("Implement splash screen").id(UUID.randomUUID().toString()).build();
        Ticket ticket2 = Ticket.builder().title("Add HTTP library").appId(product1.getId()).status("resolved").description("Implements Retrofit library").id(UUID.randomUUID().toString()).build();
        Ticket ticket3 = Ticket.builder().title("add UI Animation").appId(product1.getId()).status("open").description("Implement lottie animations").id(UUID.randomUUID().toString()).build();

        mongoTemplate.insert(ticket1);
        mongoTemplate.insert(ticket2);
        mongoTemplate.insert(ticket3);

        Release release1 = Release.builder()
                .id(UUID.randomUUID().toString())
                .tickets(Arrays.asList(ticket1,ticket2,ticket3))
                //.releaseDate(LocalDate.of(2021, 6, 23))
                .description("release 1 is right here")
                .name("customer are willing to pay").build();
        mongoTemplate.insert(release1);

        Query query = new Query();
        query.addCriteria(Criteria.where("owner").is(product1.getOwner()));
        Update update = new Update();
        update.set("owner","Moshe");
        mongoTemplate.updateFirst(query,update,Product.class);


        query = new Query();
        query.addCriteria(
                Criteria
                .where("tickets.status")
                .is("closed")
        );

        System.out.println(mongoTemplate.find(query,Release.class));

    }
}
