package com.grupo2.gestionpedidos.services.impl;

import com.grupo2.gestionpedidos.dtos.ProductRequest;
import com.grupo2.gestionpedidos.dtos.ProductResponse;
import com.grupo2.gestionpedidos.mappers.ProductMapper;
import com.grupo2.gestionpedidos.repositories.ProductRepository;
import com.grupo2.gestionpedidos.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public ProductResponse findById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::productToProductResponse)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public ProductResponse save(ProductRequest productRequest) {
        return null;
    }

    @Override
    public ProductResponse update(ProductRequest productRequest, Long id) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
