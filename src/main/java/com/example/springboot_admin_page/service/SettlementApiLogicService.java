package com.example.springboot_admin_page.service;

import com.example.springboot_admin_page.model.entity.Settlement;
import com.example.springboot_admin_page.model.entity.User;
import com.example.springboot_admin_page.model.network.Header;
import com.example.springboot_admin_page.model.network.response.SettlementApiResponse;
import com.example.springboot_admin_page.model.network.response.UserApiResponse;
import com.example.springboot_admin_page.repository.SettlementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class SettlementApiLogicService {

    @Autowired
    private SettlementRepository settlementRepository;

    public boolean updateTable(){

        try{
            settlementRepository.updateTable();
            return true;

        }catch(Exception e){
            log.error("Update settlement table error>>>>>>>" + e.getMessage());
            return false;

        }

    }

    public Header<SettlementApiResponse> updateAndRead(Long id){

        Boolean updateResult = updateTable();
        if (updateResult){
            Optional<Settlement> optional = settlementRepository.findById(id);

            return optional.map(settlement -> response(settlement))
                    .orElseGet(() -> Header.ERROR("데이터 없음"));

        }else{
            return Header.ERROR("settlement 조회 불가 (DB ERROR)");
        }
    }

    private Header<SettlementApiResponse> response(Settlement settlement){
        SettlementApiResponse body = SettlementApiResponse.builder()
                .userId(settlement.getUserId())
                .priceSum(settlement.getPriceSum())
                .build();

        return Header.OK(body);
    }
}
