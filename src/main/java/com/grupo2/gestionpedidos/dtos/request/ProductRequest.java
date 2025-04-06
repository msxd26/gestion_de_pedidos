package com.grupo2.gestionpedidos.dtos.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @NotBlank(message = "Es requerido !!")
    private String nameProduct;

    @Min(value = 1)
    private Integer stockProduct;

    @DecimalMin(value = "0.0")
    private BigDecimal priceProduct;

    @NotBlank(message = "Es requerido !!")
    private String descriptionProduct;
}
