package com.grupo2.gestionpedidos.services.impl;

import com.grupo2.gestionpedidos.dtos.request.ProductRequest;
import com.grupo2.gestionpedidos.dtos.response.ProductResponse;
import com.grupo2.gestionpedidos.entities.Product;
import com.grupo2.gestionpedidos.exceptions.ProductNotFoundException;
import com.grupo2.gestionpedidos.exceptions.ProductSaveException;
import com.grupo2.gestionpedidos.mappers.ProductMapper;
import com.grupo2.gestionpedidos.repositories.ProductRepository;
import com.grupo2.gestionpedidos.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    private final ProductMapper productMapper;


    @Override
    @Transactional(readOnly = true)
    public ProductResponse findById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::productToProductResponse)
                .orElseThrow(() -> new ProductNotFoundException("Producto no encontrado : " + id));
    }

    @Override
    @Transactional
    public ProductResponse save(ProductRequest productRequest) {
        return Optional.of(productRequest).map(productMapper::productRequestToProduct)
                .map(productRepository::save)
                .map(productMapper::productToProductResponse)
                .orElseThrow(() -> new ProductSaveException("No se puede guardar el producto"));
    }

    @Override
    @Transactional
    public ProductResponse update(ProductRequest productRequest, Long id) {
        return productRepository.findById(id).map(productUpdate -> {
                    productUpdate.setName(productRequest.getNameProduct());
                    productUpdate.setPrice(productRequest.getPriceProduct());
                    productUpdate.setDescription(productRequest.getDescriptionProduct());
                    productUpdate.setStock(productRequest.getStockProduct());
                    return productRepository.save(productUpdate);
                })
                .map(productMapper::productToProductResponse)
                .orElseThrow(() -> new ProductNotFoundException("No se encuentra este producto " + id));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("No se encontró el producto con ID: " + id));
        productRepository.delete(product);
    }
}
