package com.example.springboot_admin_page.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderType {
    ALL(0,"묶음","모든상품 묶음배송"),
    EACH(1,"개별","개별배송");

    private Integer id;
    private String title;
    private String description;
}
