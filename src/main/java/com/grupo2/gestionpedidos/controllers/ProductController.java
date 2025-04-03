package com.grupo2.gestionpedidos.controllers;

import com.grupo2.gestionpedidos.dtos.ProductResponse;
import com.grupo2.gestionpedidos.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("{id}")
    public ProductResponse findById(@PathVariable Long id) {
        return productService.findById(id);
    }
}

