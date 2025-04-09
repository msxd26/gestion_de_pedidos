package com.grupo2.gestionpedidos.services;

import com.grupo2.gestionpedidos.dtos.request.UserRequest;
import com.grupo2.gestionpedidos.dtos.response.UserResponse;


public interface UserService extends CrudService<UserResponse, UserRequest, Long> {

    UserResponse findByEmail(String email);
}
