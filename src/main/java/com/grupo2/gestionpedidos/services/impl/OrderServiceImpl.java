package com.grupo2.gestionpedidos.services.impl;

import com.grupo2.gestionpedidos.dtos.request.OrderRequest;
import com.grupo2.gestionpedidos.dtos.response.OrderResponse;
import com.grupo2.gestionpedidos.entities.Order;
import com.grupo2.gestionpedidos.entities.OrderDetail;
import com.grupo2.gestionpedidos.exceptions.OrderNotFoundException;
import com.grupo2.gestionpedidos.exceptions.OrderSaveException;
import com.grupo2.gestionpedidos.mappers.OrderDetailMapper;
import com.grupo2.gestionpedidos.mappers.OrderMapper;
import com.grupo2.gestionpedidos.mappers.ProductMapper;
import com.grupo2.gestionpedidos.repositories.OrderDetailRepository;
import com.grupo2.gestionpedidos.repositories.OrderRepository;
import com.grupo2.gestionpedidos.repositories.ProductRepository;
import com.grupo2.gestionpedidos.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;
    private final OrderDetailMapper orderDetailMapper;
    private final ProductMapper productMapper;


    @Override
    @Transactional(readOnly = true)
    public OrderResponse findById(Long id) {
        return orderRepository.findById(id)
                .map(orderMapper::orderToOrderResponse)
                .orElseThrow(() -> new OrderNotFoundException("No existe el numero de order: " + id));
    }

    @Override
    @Transactional
    public OrderResponse save(OrderRequest orderRequest) {

        Order order = orderMapper.orderRequestToOrder(orderRequest);
        if (order.getOrderDetails() != null) {
            for (OrderDetail orderDetail : order.getOrderDetails()) {
                orderDetail.setOrder(order);
            }
        }
        return Optional.of(order)
                .map(orderRepository::save)
                .map(orderMapper::orderToOrderResponse)
                .orElseThrow(() -> new OrderSaveException("No se puede guardar la orden"));
    }

    @Override
    @Transactional
    public OrderResponse update(OrderRequest orderRequest, Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("No existe el numero de order: " + id));

        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        orderRepository.delete(order);
    }
}
