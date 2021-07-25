package com.example.springboot_admin_page.ifs;

import com.example.springboot_admin_page.model.network.Header;
import com.example.springboot_admin_page.model.network.request.UserApiRequest;
import org.springframework.web.bind.annotation.RequestBody;

public interface CrudInterface<Req,Res> {

    Header<Res> create(Req request);

    Header<Res> read(Long id);

    Header<Res> update(Req request);

    Header delete(Long id);

}
