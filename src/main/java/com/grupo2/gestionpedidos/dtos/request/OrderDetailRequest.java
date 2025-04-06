package com.grupo2.gestionpedidos.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailRequest {

    private Long orderId;
    private Long productId;
    private Integer quantity;
    private BigDecimal price;
}
