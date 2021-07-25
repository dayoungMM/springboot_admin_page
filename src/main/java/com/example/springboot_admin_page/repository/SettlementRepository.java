package com.example.springboot_admin_page.repository;

import com.example.springboot_admin_page.model.entity.Settlement;
import com.example.springboot_admin_page.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface SettlementRepository extends JpaRepository<Settlement,Long> {

    @Query("UPDATE settlement s"
            + "SET user_id = (SELECT id FROM user u WHERE s.user_id = u.id),"
            + "price_sum = (SELECT price_sum "
            + "FROM"
            +        "(SELECT u.id as user_id, o.price_sum as price_sum"
            +         "FROM user u"
            +         "LEFT JOIN (SELECT user_id,SUM(total_price)as price_sum"
            +                    "FROM order_group"
            +                     "GROUP BY user_id) o ON u.id = o.user_id) j"
            +  "WHERE"
            +       "j.user_id = s.user_id)")
    public void updateTable();
}
