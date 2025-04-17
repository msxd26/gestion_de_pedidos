package com.grupo2.gestionpedidos.controllers;

import com.grupo2.gestionpedidos.dtos.request.OrderRequest;
import com.grupo2.gestionpedidos.dtos.response.OrderResponse;
import com.grupo2.gestionpedidos.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;


    @GetMapping("{id}")
    public ResponseEntity<OrderResponse> findById(@Valid @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findById(id));
    }

    @PostMapping
    public ResponseEntity<OrderResponse> save(@Valid @RequestBody OrderRequest orderRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(orderRequest));
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderResponse> update(@Valid @RequestBody OrderRequest orderRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.update(orderRequest, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<OrderResponse> delete(@Valid @PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
