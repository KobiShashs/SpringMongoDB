package com.johnbryce.mymongo.clr;

import com.johnbryce.mymongo.model.User;
import com.johnbryce.mymongo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class Test implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(1,"Shasha","Yaakov");
        userRepository.insert(u1);
        userRepository.insert(new User(2,"Cohen","Rinat"));


        System.out.println(userRepository.findAll());

        u1.setFirst("Kobi");
        userRepository.save(u1);

        userRepository.deleteById(2);

    }
}
