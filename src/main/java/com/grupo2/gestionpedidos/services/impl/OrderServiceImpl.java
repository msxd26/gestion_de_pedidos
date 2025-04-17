package com.grupo2.gestionpedidos.services.impl;

import com.grupo2.gestionpedidos.dtos.request.OrderRequest;
import com.grupo2.gestionpedidos.dtos.response.OrderResponse;
import com.grupo2.gestionpedidos.entities.Order;
import com.grupo2.gestionpedidos.entities.OrderDetail;
import com.grupo2.gestionpedidos.entities.Product;
import com.grupo2.gestionpedidos.exceptions.OrderCancelException;
import com.grupo2.gestionpedidos.exceptions.OrderNotFoundException;
import com.grupo2.gestionpedidos.exceptions.OrderUpdateException;
import com.grupo2.gestionpedidos.exceptions.ProductNotFoundException;
import com.grupo2.gestionpedidos.exceptions.StockException;
import com.grupo2.gestionpedidos.kafka.OrderEventProducer;
import com.grupo2.gestionpedidos.mappers.OrderMapper;
import com.grupo2.gestionpedidos.repositories.OrderRepository;
import com.grupo2.gestionpedidos.repositories.ProductRepository;
import com.grupo2.gestionpedidos.services.OrderService;
import com.grupo2.gestionpedidos.utils.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;
    private final OrderEventProducer orderEventProducer;


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
        totalPrice(order);
        order.setStatus(Status.CREATED);
        Order savedOrder = orderRepository.save(order);
        var response = orderMapper.orderToOrderResponse(savedOrder);
        orderEventProducer.sendOrderCreatedEvent(response);
        return response;
    }

    @Override
    @Transactional
    public OrderResponse update(OrderRequest orderRequest, Long id) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("No existe el numero de order: " + id));

        if (existingOrder.getStatus() != Status.SHIPPED) {
            throw new OrderUpdateException("No se puede modificar una orden que no está en estado DELIVERED");
        }

        restoreProductStock(existingOrder);

        Order updatedOrder = orderMapper.orderRequestToOrder(orderRequest);
        updatedOrder.setId(id);
        totalPrice(updatedOrder);
        updatedOrder.setStatus(updatedOrder.getStatus());

        Order savedOrder = orderRepository.save(updatedOrder);
        var response = orderMapper.orderToOrderResponse(savedOrder);
        orderEventProducer.sendOrderUpdatedEvent(response);
        return response;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("No existe el numero de order: " + id));

        if (order.getStatus() == Status.SHIPPED) {
            throw new OrderCancelException("No se puede cancelar una orden que no está en estado SHIPPED");
        }
        restoreProductStock(order);

        orderRepository.delete(order);

        orderEventProducer.sendOrderDeletedEvent(id);

    }

    private void totalPrice(Order order) {
        BigDecimal total = BigDecimal.ZERO;
        if (order.getOrderDetails() != null) {
            for (OrderDetail orderDetail : order.getOrderDetails()) {
                Product product = productRepository.findById(orderDetail.getProduct().getId())
                        .orElseThrow(() -> new ProductNotFoundException("Producto no encontrado"));

                if (product.getStock() < orderDetail.getQuantity()) {
                    throw new StockException("Stock insuficiente para el producto: " + product.getName());
                }

                product.setStock(product.getStock() - orderDetail.getQuantity());
                productRepository.save(product);

                BigDecimal subtotal = orderDetail.getPrice().multiply(BigDecimal.valueOf(orderDetail.getQuantity()));
                total = total.add(subtotal);
                orderDetail.setOrder(order);
            }
        }
        order.setTotal(total);
    }


    private void restoreProductStock(Order order) {
        if (order.getOrderDetails() != null) {
            for (OrderDetail orderDetail : order.getOrderDetails()) {
                Product product = orderDetail.getProduct();
                product.setStock(product.getStock() + orderDetail.getQuantity());
                productRepository.save(product);
            }
        }
    }
}
