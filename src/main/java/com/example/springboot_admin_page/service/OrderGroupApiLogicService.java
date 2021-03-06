package com.example.springboot_admin_page.service;

import com.example.springboot_admin_page.ifs.CrudInterface;
import com.example.springboot_admin_page.model.entity.Item;
import com.example.springboot_admin_page.model.entity.OrderGroup;
import com.example.springboot_admin_page.model.network.Header;
import com.example.springboot_admin_page.model.network.request.ItemApiRequest;
import com.example.springboot_admin_page.model.network.request.OrderGroupApiRequest;
import com.example.springboot_admin_page.model.network.response.ItemApiResponse;
import com.example.springboot_admin_page.model.network.response.OrderGroupApiResponse;
import com.example.springboot_admin_page.repository.ItemRepository;
import com.example.springboot_admin_page.repository.OrderGroupRepository;
import com.example.springboot_admin_page.repository.PartnerRepository;
import com.example.springboot_admin_page.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderGroupApiLogicService extends BaseService<OrderGroupApiRequest, OrderGroupApiResponse,OrderGroup> {

//    @Autowired
//    private OrderGroupRepository orderGroupRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request) {
        OrderGroupApiRequest body = request.getData();

        OrderGroup orderGroup = OrderGroup.builder()
                .status(body.getStatus())
                .orderType(body.getOrderType())
                .revAddress(body.getRevAddress())
                .revName(body.getRevName())
                .paymentType(body.getPaymentType())
                .totalPrice(body.getTotalPrice())
                .totalQuantity(body.getTotalQuantity())
                .orderAt(body.getOrderAt())
                .arrivalDate(body.getArrivalDate())
                .user(userRepository.getById(body.getUserId()))
                .build();

        OrderGroup newOrderGroup = baseRepository.save(orderGroup);

        return response(newOrderGroup);


    }

    @Override
    public Header<OrderGroupApiResponse> read(Long id) {
        return baseRepository.findById(id)
                .map(this::response)
                .orElseGet(() -> Header.ERROR("???????????????"));
    }

    @Override
    public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {
        OrderGroupApiRequest body = request.getData();

        return baseRepository.findById(body.getId())
                .map(orderGroup -> {
                    orderGroup
                            .setStatus(body.getStatus())
                            .setOrderType(body.getOrderType())
                            .setRevAddress(body.getRevAddress())
                            .setRevName(body.getRevName())
                            .setPaymentType(body.getPaymentType())
                            .setTotalQuantity(body.getTotalQuantity())
                            .setTotalPrice(body.getTotalPrice())
                            .setOrderAt(body.getOrderAt())
                            .setArrivalDate(body.getArrivalDate())
                            .setUser(userRepository.getById(body.getUserId()))
                            ;

                    return orderGroup;

                })

                .map(changedOrderGroup -> baseRepository.save(changedOrderGroup))
                .map(this::response)
                .orElseGet(() -> Header.ERROR("???????????????"));


    }

    @Override
    public Header delete(Long id) {
        return baseRepository.findById(id)
                .map(orderGroup -> {
                    baseRepository.delete(orderGroup);
                    return Header.OK();
                })
                .orElseGet(()->Header.ERROR("???????????????"));
    }

    private Header<OrderGroupApiResponse> response(OrderGroup orderGroup){
        OrderGroupApiResponse body = OrderGroupApiResponse.builder()
                .id(orderGroup.getId())
                .status(orderGroup.getStatus())
                .orderType(orderGroup.getOrderType())
                .revAddress(orderGroup.getRevAddress())
                .revName(orderGroup.getRevName())
                .paymentType(orderGroup.getPaymentType())
                .totalPrice(orderGroup.getTotalPrice())
                .totalQuantity(orderGroup.getTotalQuantity())
                .orderAt(orderGroup.getOrderAt())
                .arrivalDate(orderGroup.getArrivalDate())
                .userId(orderGroup.getUser().getId())
                .build();

        return Header.OK(body);
    }
}
