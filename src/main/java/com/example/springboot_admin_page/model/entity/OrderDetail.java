package com.example.springboot_admin_page.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

// lombok을 쓰게 되면 ToString 자동으로 만들어주는데 user, item이 서로 상호충돌 나서 에러생김. 연관관계인 경우 exclude해서 충돌 막아야함
//@ToString(exclude = {"user","item"})
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    private Long itemId;

    private Long orderGroupId;

//
//    //N:1 = orderdetail: user
//    @ManyToOne
//    private User user; //user_id 알아서 찾아
//
//    @ManyToOne
//    private Item item;


}
