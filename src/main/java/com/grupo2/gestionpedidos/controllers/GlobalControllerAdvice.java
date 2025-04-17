package com.grupo2.gestionpedidos.controllers;

import com.grupo2.gestionpedidos.exceptions.OrderNotFoundException;
import com.grupo2.gestionpedidos.exceptions.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(GlobalControllerAdvice.class);

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException ex) {
        logger.error("Producto no encontrado: {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("mensaje", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<?> handlerOrder(OrderNotFoundException ex) {
        logger.error("Order no encontrada : {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("mensaje", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
        logger.error("Error de validación: {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put("El campo " + error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}