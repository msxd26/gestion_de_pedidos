package com.grupo2.gestionpedidos.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailResponse {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private BigDecimal price;
}
