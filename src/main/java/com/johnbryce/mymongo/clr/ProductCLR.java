package com.johnbryce.mymongo.clr;

import com.johnbryce.mymongo.model.Product;
import com.johnbryce.mymongo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.UUID;

//@Component
public class ProductCLR implements CommandLineRunner {

    @Autowired
    private ProductRepository pr;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("I'm going go delete all products...");
        pr.deleteAll();

        System.out.println("Going to add 3 Products into MongoDB...");
        Product product = new Product(UUID.randomUUID().toString(),"Android","Playstudios Android App","Chen");
        pr.insert(product);
        pr.insert(new Product(UUID.randomUUID().toString(),"iOS","Playstudios iOS App","Noy"));
        pr.insert(new Product(UUID.randomUUID().toString(),"Backend","Playstudios Android App","Tom"));

        System.out.println("Going to print all products...");
        System.out.println(pr.findAll());

        System.out.println("Going to print product by id...");
        System.out.println(pr.findById(product.getId()));

        System.out.println("Going to update product...");
        product.setDescription("Wubalubadubdub!");//https://www.youtube.com/watch?v=wTuYeMMtozw
        pr.save(product);
        System.out.println(pr.findAll());

//
        System.out.println("Going to delete product...");
        pr.delete(product);
//
//        System.out.println("Going to print all products...");
//        System.out.println(pr.findAll());


    }
}
