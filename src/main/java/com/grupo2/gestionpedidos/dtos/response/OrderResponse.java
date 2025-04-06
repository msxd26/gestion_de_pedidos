package com.grupo2.gestionpedidos.dtos.response;

import com.grupo2.gestionpedidos.utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private Long idOrder;

    private Long userIdOrder;

    private LocalDateTime orderDate;

    private Status statusOrder;

    private List<OrderDetailResponse> orderDetails;


}
