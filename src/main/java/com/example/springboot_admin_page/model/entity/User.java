package com.example.springboot_admin_page.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"orderGroup"})
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    //LAZY = 지연로딩, EAGER=즉시로딩
    //LAZY = SELECT * FROM item where id= ?
    // EAGER =
    // item_id = order_detail.item_id
    //user_id = order_detail.user_id
    //where item.id = ?
    // 연관관계 있는 테이블 다 JOIN 하고 그 테이블에서 Select
    // JOIN 할게 많으면 select 하나만 해도 엄청 오래걸릴 수 있음
    // 따라서 EAGER는 1:1 일때 추천


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;

}
