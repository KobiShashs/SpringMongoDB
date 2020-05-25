package com.johnbryce.mymongo.clr;

import com.johnbryce.mymongo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Order(1)
public class RemoveAllCLR implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ReleaseRepository releaseRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        personRepository.deleteAll();
        customerRepository.deleteAll();
        productRepository.deleteAll();
        releaseRepository.deleteAll();
        ticketRepository.deleteAll();
        userRepository.deleteAll();
    }
}
