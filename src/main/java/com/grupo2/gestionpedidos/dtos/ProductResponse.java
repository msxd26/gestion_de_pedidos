package com.grupo2.gestionpedidos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private Long idProduct;

    private String nameProduct;

    private Integer stockProduct;

    private BigDecimal priceProduct;

    private String descriptionProduct;
}
