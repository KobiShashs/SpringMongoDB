package com.johnbryce.mymongo.clr;

import com.johnbryce.mymongo.model.Customer;
import com.johnbryce.mymongo.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Order(2)
public class CustomerCLR implements CommandLineRunner {
    @Autowired
    private CustomerRepository cr;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("I'm going go delete all customers...");
        cr.deleteAll();

        System.out.println("Going to add 2 Customers into MongoDB...");
        cr.save(new Customer(1,"Alice", "Smith"));
        cr.save(new Customer(2,"Bob", "Smith"));

        System.out.println("Customers found with findAll()...");
        for (Customer customer : cr.findAll()) {
            System.out.println(customer);
        }

        System.out.println("Customer found with findByFirstName('Alice')...");
        System.out.println(cr.findByFirstName("Alice"));

    }
}
