package com.grupo2.gestionpedidos.mappers;

import com.grupo2.gestionpedidos.dtos.request.OrderRequest;
import com.grupo2.gestionpedidos.dtos.response.OrderResponse;
import com.grupo2.gestionpedidos.entities.Order;
import com.grupo2.gestionpedidos.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {OrderDetailMapper.class})
public interface OrderMapper {

    @Mapping(source = "id", target = "idOrder")
    @Mapping(source = "user.id", target = "userIdOrder")
    @Mapping(source = "orderDate", target = "orderDate")
    @Mapping(source = "status", target = "statusOrder")
    @Mapping(source = "orderDetails", target = "orderDetails")
    @Mapping(source = "total", target = "totalOrder")
    OrderResponse orderToOrderResponse(Order order);

    @Mapping(source = "idUserOrder", target = "user")
    @Mapping(source = "orderDetails", target = "orderDetails")
    Order orderRequestToOrder(OrderRequest orderRequest);


    default User map(Long idUser) {
        if (idUser == null) {
            return null;
        }
        User user = new User();
        user.setId(idUser);
        return user;
    }


}
