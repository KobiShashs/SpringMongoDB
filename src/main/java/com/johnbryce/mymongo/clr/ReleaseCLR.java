package com.johnbryce.mymongo.clr;

import com.johnbryce.mymongo.model.Product;
import com.johnbryce.mymongo.model.Release;
import com.johnbryce.mymongo.model.Ticket;
import com.johnbryce.mymongo.repo.ProductRepository;
import com.johnbryce.mymongo.repo.ReleaseRepository;
import com.johnbryce.mymongo.repo.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@Component
public class ReleaseCLR implements CommandLineRunner {

    @Autowired
    private ProductRepository pr;

    @Autowired
    private TicketRepository tr;

    @Autowired
    ReleaseRepository rr;

    @Override
    public void run(String... args) throws Exception {

        pr.deleteAll();
        tr.deleteAll();
        rr.deleteAll();
        Product product1 = new Product(UUID.randomUUID().toString(),"Android","Playstudios Android App","Chen");
        Product product2 = new Product(UUID.randomUUID().toString(),"iOS","Playstudios iOS App","Noy");
        Product product3 = new Product(UUID.randomUUID().toString(),"Backend","Playstudios Android App","Tom");
        Product product4 = Product.builder().id(UUID.randomUUID().toString()).description("Playstudios DS Team").name("DS").build();
        pr.insert(product1);
        pr.insert(product2);
        pr.insert(product3);
        pr.insert(product4);
        System.out.println("Watch unsigned value injection");
        System.out.println(pr.findById(product4.getId()));


        Ticket ticket1 = Ticket.builder().title("Splash screen")
                .appId(product1.getId())
                .status("open")
                .description("Implement splash screen")
                .id(UUID.randomUUID().toString()).build();
        Ticket ticket2 = Ticket.builder().title("Add HTTP library").appId(product1.getId()).status("resolved").description("Implements Retrofit library").id(UUID.randomUUID().toString()).build();
        Ticket ticket3 = Ticket.builder().title("add UI Animation").appId(product1.getId()).status("open").description("Implement lottie animations").id(UUID.randomUUID().toString()).build();
        tr.insert(ticket1);
        tr.insert(ticket2);
        tr.insert(ticket3);
        System.out.println("Example for @Indexed Usage --->"+ ticket1.getAppId());
        System.out.println(tr.findByAppId(ticket1.getAppId()));
        System.out.println("----------------------------");
        Ticket ticket4 = Ticket.builder().title("iOS 13 support").appId(product2.getId()).status("open").description("I hate this shit").id(UUID.randomUUID().toString()).build();
        Ticket ticket5 = Ticket.builder().title("Add HTTP library").appId(product2.getId()).status("resolved").description("Implements some library").id(UUID.randomUUID().toString()).build();
        Ticket ticket6 = Ticket.builder().title("add UI Animation").appId(product2.getId()).status("open").description("Implement lottie animations").id(UUID.randomUUID().toString()).build();
        tr.insert(ticket4);
        tr.insert(ticket5);
        tr.insert(ticket6);

//        Release release1 = Release.builder().estimateCosts(0.00).id(UUID.randomUUID().toString()).tickets(Arrays.asList(ticket1,ticket2,ticket3,ticket4,ticket5,ticket6)).releaseDate(LocalDate.of(2021, 6, 23)).description("release 1 is right here").name("customer are willing to pay").build();
        ZonedDateTime zonedDateTime  = ZonedDateTime.of(LocalDate.of(2021, 6, 23), LocalTime.of(15,30), ZoneId.of("UTC"));
        Release release1 = Release.builder()
                .estimateCosts(0.00).id(UUID.randomUUID().toString())
                .tickets(Arrays.asList(ticket1,ticket2,ticket3,ticket4,ticket5,ticket6))
                .releaseDate(zonedDateTime)
                .description("release 1 is right here")
                .name("customer are willing to pay")
                .build();

        rr.insert(release1);
        System.out.println("Release info");
        System.out.println(rr.findAll());


        Double cost = 0.00;
        Optional<Release> release  = rr.findById(release1.getId());
        if(release.isPresent()) cost = release.get().getEstimateCosts();
        System.out.println(String.format("Cost = %f",cost));

        System.out.println(tr.findAllByCustomQueryAndStream("resolved").findAny());



    }
}
