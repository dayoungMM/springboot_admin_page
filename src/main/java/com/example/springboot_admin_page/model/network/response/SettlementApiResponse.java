package com.example.springboot_admin_page.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SettlementApiResponse {
   private String userId;

   private BigDecimal priceSum;
}
