package com.grupo2.gestionpedidos.kafka;

import com.grupo2.gestionpedidos.dtos.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.topic.orders-created}")
    private String ordersCreatedTopic;

    @Value("${kafka.topic.orders-updated}")
    private String ordersUpdatedTopic;

    @Value("${kafka.topic.orders-deleted}")
    private String ordersDeletedTopic;

    public void sendOrderCreatedEvent(OrderResponse order) {
        kafkaTemplate.send(ordersCreatedTopic, order);
    }

    public void sendOrderUpdatedEvent(OrderResponse order) {
        kafkaTemplate.send(ordersUpdatedTopic, order);
    }

    public void sendOrderDeletedEvent(Long orderId) {
        kafkaTemplate.send(ordersDeletedTopic, orderId);
    }
}
