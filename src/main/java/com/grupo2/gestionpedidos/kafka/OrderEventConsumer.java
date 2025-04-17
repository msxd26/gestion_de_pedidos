package com.grupo2.gestionpedidos.kafka;


import com.grupo2.gestionpedidos.dtos.response.OrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderEventConsumer {


    @KafkaListener(topics = "${kafka.topic.orders-created}", groupId = "order-group")
    public void listenOrderCreated(OrderResponse order) {
        log.info("Orden CREADA recibida: {}", order.getIdOrder());
    }

    @KafkaListener(topics = "${kafka.topic.orders-updated}", groupId = "order-group")
    public void listenOrderUpdated(OrderResponse order) {
        log.info("Orden ACTUALIZADA recibida: {}", order.getIdOrder());
    }

    @KafkaListener(topics = "${kafka.topic.orders-deleted}", groupId = "order-group")
    public void listenOrderDeleted(Long orderId) {
        log.info("Orden ELIMINADA recibida: {}", orderId);
    }
}