package com.johnbryce.mymongo.clr;

import com.johnbryce.mymongo.model.Person;
import com.johnbryce.mymongo.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class PersonCLR implements CommandLineRunner {

    @Autowired
    private PersonRepository pr;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("I'm going go delete all persons...");
        pr.deleteAll();

        System.out.println("Going to add 4 Persons into MongoDB...");
        pr.insert(new Person(1,"Kobi","Shasha"));
        pr.insert(new Person(2,"Tom","Shadmi"));
        pr.insert(new Person(3,"Yaakov","Shasha"));
        pr.insert(new Person(4,"Rony","Keren"));
    }
}
