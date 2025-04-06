package com.grupo2.gestionpedidos.services;

import com.grupo2.gestionpedidos.dtos.request.OrderRequest;
import com.grupo2.gestionpedidos.dtos.response.OrderResponse;

public interface OrderService extends CrudService<OrderResponse, OrderRequest, Long> {
}
