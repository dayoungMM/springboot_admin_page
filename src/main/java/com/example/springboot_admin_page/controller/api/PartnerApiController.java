package com.example.springboot_admin_page.controller.api;

import com.example.springboot_admin_page.controller.CrudController;
import com.example.springboot_admin_page.model.entity.Partner;
import com.example.springboot_admin_page.model.network.request.PartnerApiRequest;
import com.example.springboot_admin_page.model.network.response.PartnerApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner> {

}
