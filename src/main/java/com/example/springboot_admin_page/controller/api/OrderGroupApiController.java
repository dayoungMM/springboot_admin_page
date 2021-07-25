package com.example.springboot_admin_page.controller.api;

import com.example.springboot_admin_page.controller.CrudController;
import com.example.springboot_admin_page.ifs.CrudInterface;
import com.example.springboot_admin_page.model.network.Header;


import com.example.springboot_admin_page.model.network.request.OrderGroupApiRequest;
import com.example.springboot_admin_page.model.network.response.OrderGroupApiResponse;

import com.example.springboot_admin_page.service.OrderGroupApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @PostConstruct
    public void init(){
        this.baseService = orderGroupApiLogicService;
    }

}
