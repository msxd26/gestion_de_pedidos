package com.grupo2.gestionpedidos.exceptions;

public class OrderSaveException extends RuntimeException {

    public OrderSaveException(String message) {
        super(message);
    }
}
