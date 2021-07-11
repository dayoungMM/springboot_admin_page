package com.example.springboot_admin_page.repository;

import com.example.springboot_admin_page.SpringbootAdminPageApplication;
import com.example.springboot_admin_page.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class UserRepositoryTest extends SpringbootAdminPageApplication {

    //직접 객체 안만들고 알아서 의존성주입을 해줌. Dependency Injection
    // singletone만
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();
        user.setAccount("TestUser02");
        user.setEmail("TestUser02@gmail.com");
        user.setPhoneNumber("010-2111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");


        User newUser = userRepository.save(user);
        System.out.println("newUser: "  + newUser);
    }

    @Test
    public void read(){
        Optional<User> user = userRepository.findById(2L);


        user.ifPresent(selectUser -> {
            System.out.println("user: " + selectUser);
            System.out.println("email: "+ selectUser.getEmail());
        });

    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(2L);


        user.ifPresent(selectUser -> {
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });

    }
}
