package com.johnbryce.mymongo;

import com.johnbryce.mymongo.repo.CustomerRepository;
import com.johnbryce.mymongo.repo.PersonRepository;
import com.johnbryce.mymongo.model.Customer;
import com.johnbryce.mymongo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


//@RequestMapping("/myApp")
//@RestController
@SpringBootApplication
public class MyMongoApplication {

    public static void main(String[] args) {
       //System.out.println("START");
        ApplicationContext ctx = SpringApplication.run(MyMongoApplication.class, args);
        System.out.println("END");
    }


//    @GetMapping("/greet/{token}")
//    public ResponseEntity<?> sayHello(@PathVariable("token") String token) {
//
//        if (token.startsWith("1")) {
//            return new ResponseEntity<String>( "Hello World", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<String>("Validation issue",HttpStatus.BAD_REQUEST);
//        }
//
//    }
//
//    @GetMapping("/mosh")
//    public ResponseEntity<?> getMoshe(){
//
//        return new ResponseEntity<Moshe>(Moshe.builder().id(UUID.randomUUID()).name("Moshon").build(),HttpStatus.OK);
//    }


}
