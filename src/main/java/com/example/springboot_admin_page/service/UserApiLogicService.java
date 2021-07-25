package com.example.springboot_admin_page.service;

import com.example.springboot_admin_page.ifs.CrudInterface;
import com.example.springboot_admin_page.model.network.Header;
import com.example.springboot_admin_page.model.network.request.UserApiRequest;
import com.example.springboot_admin_page.model.network.response.UserApiResponse;
import com.example.springboot_admin_page.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    //request data 가져오기
    // user 생성
    // 생성된 데이터를 가지고 UserApiResponse를 만들어서 return
    @Override
    public Header<UserApiResponse> create(UserApiRequest request) {
        return null;
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<UserApiResponse> update(UserApiRequest request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }
}
