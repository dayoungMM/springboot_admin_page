package com.example.springboot_admin_page.ifs;

import com.example.springboot_admin_page.model.network.Header;

public interface CrudInterface {

    Header create();

    Header read(Long id);

    Header update();

    Header delete(Long id);

}
