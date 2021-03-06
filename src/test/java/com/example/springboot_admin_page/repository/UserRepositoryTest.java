package com.example.springboot_admin_page.repository;

import com.example.springboot_admin_page.SpringbootAdminPageApplication;
import com.example.springboot_admin_page.model.entity.Item;
import com.example.springboot_admin_page.model.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.transaction.Transactional;
import java.time.LocalDate;
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
        String account = "TEST04";
        String password = "TEST04";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-3333-4444";
        LocalDateTime registeredAt  = LocalDateTime.now();
//        LocalDateTime createdAt = LocalDateTime.now();
//        String createdBy = "AdminServer";



        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
//        user.setCreatedAt(createdAt);
//        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);

        Assert.assertNotNull(newUser);

//        User u = User.builder().account(account).password(password).status(status).email(email).build();

    }
    @Test
    @Transactional
    public void read(){
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        user.getOrderGroupList().stream().forEach(orderGroup -> {
            System.out.println("---------------주문묶음--------------");
            System.out.println("수령인: "+ orderGroup.getRevName());
            System.out.println("수령지: " + orderGroup.getRevAddress());
            System.out.println("총금액: " + orderGroup.getTotalPrice());
            System.out.println("총수량: " + orderGroup.getTotalQuantity());


            System.out.println("---------------주문상세--------------");

            orderGroup.getOrderDetailList().forEach(orderDetail -> {
                System.out.println("파트너사 이름: "+ orderDetail.getItem().getPartner().getName());
                System.out.println("파트너사 카테고리: "+ orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("주문상품: "+ orderDetail.getItem().getName());
                System.out.println("고객센터 번호: "+ orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("주문의 상태: " + orderDetail.getStatus());
                System.out.println("도착예정일자: " + orderDetail.getArrivalDate());

            });
        });
        Assert.assertNotNull(user);
    }
//
//    @Test
//    @Transactional
//    public void update(){
//        Optional<User> user = userRepository.findById(2L);
//
//
//        user.ifPresent(selectUser -> {
//            selectUser.setAccount("pppp");
//            selectUser.setUpdatedAt(LocalDateTime.now());
//            selectUser.setUpdatedBy("update method()");
//
//            userRepository.save(selectUser);
//        });
//
//    }
//
//    @Test
//    // 데이터베이스에서 쿼리를 실행하되, 다 하고 롤백을 해서 데이터베이스에서 정보가 수정되지 않음
//    @Transactional
//    public void delete(){
//        Optional<User> user = userRepository.findById(4L);
//
//        Assert.assertTrue(user.isPresent());
//
//        user.ifPresent(selectUser -> {
//
//            userRepository.delete(selectUser);
//        });
//
//        Optional<User> deleteUser = userRepository.findById(4L);
//
//        Assert.assertFalse(deleteUser.isPresent());
////
////        if(deleteUser.isPresent()){
////            System.out.println("데이터 존재: "+ deleteUser.get());
////        }else{
////            System.out.println("데이터 삭제됨");
////        }
//
//
//    }
}
