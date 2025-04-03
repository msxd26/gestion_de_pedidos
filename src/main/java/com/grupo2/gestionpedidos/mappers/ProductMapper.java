package com.grupo2.gestionpedidos.mappers;

import com.grupo2.gestionpedidos.dtos.ProductRequest;
import com.grupo2.gestionpedidos.dtos.ProductResponse;
import com.grupo2.gestionpedidos.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "id", target = "idProduct")
    @Mapping(source = "name", target = "nameProduct")
    @Mapping(source = "stock", target = "stockProduct")
    @Mapping(source = "price", target = "priceProduct")
    @Mapping(source = "description", target = "descriptionProduct")
    ProductResponse productToProductResponse(Product product);


    @Mapping(source = "nameProduct", target = "name")
    @Mapping(source = "stockProduct", target = "stock")
    @Mapping(source = "priceProduct", target = "price")
    @Mapping(source = "descriptionProduct", target = "description")
    Product productRequestToProduct(ProductRequest productRequest);

}
