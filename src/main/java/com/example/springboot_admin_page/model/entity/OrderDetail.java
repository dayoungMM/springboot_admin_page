package com.example.springboot_admin_page.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"orderGroup","item"})
// lombok을 쓰게 되면 ToString 자동으로 만들어주는데 user, item이 서로 상호충돌 나서 에러생김. 연관관계인 경우 exclude해서 충돌 막아야함
//@ToString(exclude = {"user","item"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain=true)
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;


    @ManyToOne
    private Item item;

//    private Long orderGroupId;

    @ManyToOne
    private OrderGroup orderGroup;

//
//    //N:1 = orderdetail: user
//    @ManyToOne
//    private User user; //user_id 알아서 찾아
//
//    @ManyToOne
//    private Item item;


}
