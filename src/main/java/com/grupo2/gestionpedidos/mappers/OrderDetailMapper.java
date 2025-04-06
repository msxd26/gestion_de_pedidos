package com.grupo2.gestionpedidos.mappers;

import com.grupo2.gestionpedidos.dtos.request.OrderDetailRequest;
import com.grupo2.gestionpedidos.dtos.response.OrderDetailResponse;
import com.grupo2.gestionpedidos.entities.OrderDetail;
import com.grupo2.gestionpedidos.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {

    @Mapping(source = "product.id", target = "productId")
    OrderDetailResponse toResponse(OrderDetail orderDetail);

    @Mapping(source = "productId", target = "product")
    OrderDetail toEntity(OrderDetailRequest request);

    default Product map(Long id) {
        if (id == null) return null;
        Product product = new Product();
        product.setId(id);
        return product;
    }

}
