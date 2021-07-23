package com.example.springboot_admin_page.repository;

import com.example.springboot_admin_page.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findFirstByPhoneNumberOrdOrderByIdDesc(String phoneNumber);


}
