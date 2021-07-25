package com.example.springboot_admin_page.controller.api;


import com.example.springboot_admin_page.model.entity.Settlement;
import com.example.springboot_admin_page.model.network.Header;
import com.example.springboot_admin_page.model.network.response.SettlementApiResponse;
import com.example.springboot_admin_page.service.SettlementApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/settlement")
public class SettlementApiController {

    @Autowired
    private SettlementApiLogicService settlementApiLogicService;

    @GetMapping("/{id}")
    public Header<SettlementApiResponse> updateAndRead(@PathVariable(name="id") Long id){
        return settlementApiLogicService.updateAndRead(id);
    }


}
