package com.example.springboot_admin_page.controller.api;

import com.example.springboot_admin_page.ifs.CrudInterface;
import com.example.springboot_admin_page.model.network.Header;
import com.example.springboot_admin_page.model.network.request.UserApiRequest;
import com.example.springboot_admin_page.model.network.response.UserApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Override
    @PostMapping("")
    public Header<UserApiResponse> create(@RequestBody UserApiRequest userApiRequest) {


        return null;
    }

    @Override
    @GetMapping("/{id}")
    public Header<UserApiResponse> read(@PathVariable(name="id") Long id) {
        return null;
    }

    @Override
    @PutMapping("")
    public Header<UserApiResponse> update(@RequestBody UserApiRequest userApiRequest) {
        return null;
    }

    @Override
    @DeleteMapping("/{id}")
    public Header delete(Long id) {
        return null;
    }
}

