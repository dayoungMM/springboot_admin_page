package com.example.springboot_admin_page.repository;


import com.example.springboot_admin_page.SpringbootAdminPageApplication;
import com.example.springboot_admin_page.model.entity.Item;
import com.example.springboot_admin_page.model.enumclass.ItemStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class ItemRepositoryTest extends SpringbootAdminPageApplication {

        @Autowired
        private ItemRepository itemRepository;

        @Test
        public void create() {
            Item item = new Item();
            item.setStatus(ItemStatus.UNREGISTERED);
            item.setName("삼성 노트북");
            item.setTitle("삼성 노트북 A100");
            item.setContent("2019년형 삼성 노트북 입니다.");
//    item.setPrice(900000);
            item.setBrandName("삼성");
            item.setRegisteredAt(LocalDateTime.now());
            item.setCreatedAt(LocalDateTime.now());
            item.setCreatedBy("Partner01");
//    item.setPartnerId(1L);


            Item newItem = itemRepository.save(item);
            Assertions.assertNotNull(newItem);
        }

        @Test
        public void read() {
            Long id = 1L;

            Optional<Item> item = itemRepository.findById(id);

            Assertions.assertTrue(item.isPresent());

        }


    }

