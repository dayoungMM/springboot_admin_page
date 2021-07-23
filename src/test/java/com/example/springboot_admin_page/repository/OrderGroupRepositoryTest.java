package com.example.springboot_admin_page.repository;

import com.example.springboot_admin_page.SpringbootAdminPageApplication;
import com.example.springboot_admin_page.model.entity.OrderGroup;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootTest
public class OrderGroupRepositoryTest extends SpringbootAdminPageApplication {

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Test
    public void create(){
        OrderGroup ordergroup = new OrderGroup();
        ordergroup.setStatus("COMPLETE");
        ordergroup.setOrderType("ALL");
        ordergroup.setRevAddress("서울시 강남구");
        ordergroup.setRevName("홍길동");
        ordergroup.setPaymentType("CARD");
        ordergroup.setTotalPrice(BigDecimal.valueOf(900000));
        ordergroup.setTotalQuantity(1);
        ordergroup.setOrderAt(LocalDateTime.now().minusDays(2));
        ordergroup.setArrivalDate(LocalDateTime.now());
        ordergroup.setCreatedAt(LocalDateTime.now());
        ordergroup.setCreatedBy( "AdminServer");
        ordergroup.setUserId(1L);

        OrderGroup newOrderGroup = orderGroupRepository.save(ordergroup);
        Assert.assertNotNull(newOrderGroup);


    }
}
