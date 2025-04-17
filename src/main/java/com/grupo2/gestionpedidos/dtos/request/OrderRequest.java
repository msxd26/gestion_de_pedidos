package com.grupo2.gestionpedidos.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private Long idUserOrder;

    private List<OrderDetailRequest> orderDetails;

}
