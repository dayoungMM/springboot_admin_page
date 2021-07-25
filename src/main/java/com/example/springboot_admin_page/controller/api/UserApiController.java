package com.example.springboot_admin_page.controller.api;

import com.example.springboot_admin_page.ifs.CrudInterface;
import com.example.springboot_admin_page.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface {

    @Override
    @PostMapping("")
    public Header create() {
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public Header read(@PathVariable(name="id") Long id) {
        return null;
    }

    @Override
    @PutMapping("")
    public Header update() {
        return null;
    }

    @Override
    @DeleteMapping("/{id}")
    public Header delete(Long id) {
        return null;
    }
}

