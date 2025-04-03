package com.grupo2.gestionpedidos.services;

import com.grupo2.gestionpedidos.dtos.ProductRequest;
import com.grupo2.gestionpedidos.dtos.ProductResponse;

public interface ProductService extends CrudService<ProductResponse, ProductRequest, Long> {
}
