package com.johnbryce.mymongo.clr;

import com.johnbryce.mymongo.model.Ticket;
import com.johnbryce.mymongo.repo.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@Component
public class MyCLR implements CommandLineRunner {


    @Autowired
    TicketRepository ticketRepository;
    @Override
    public void run(String... args) throws Exception {

        Stream<Ticket> stream = ticketRepository.findAllByCustomQueryAndStream("open");
       // System.out.println(Arrays.asList(stream.toArray()));
        //System.out.println(stream.collect(Collectors.toList()));
        System.out.println(stream.collect(Collectors.toList()).size());
        stream.close();

    }
}
