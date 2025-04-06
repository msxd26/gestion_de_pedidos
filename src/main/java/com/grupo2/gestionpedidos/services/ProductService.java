package com.grupo2.gestionpedidos.services;

import com.grupo2.gestionpedidos.dtos.request.ProductRequest;
import com.grupo2.gestionpedidos.dtos.response.ProductResponse;

public interface ProductService extends CrudService<ProductResponse, ProductRequest, Long> {
}
