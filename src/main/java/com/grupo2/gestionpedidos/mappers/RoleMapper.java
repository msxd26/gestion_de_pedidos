package com.grupo2.gestionpedidos.mappers;


import com.grupo2.gestionpedidos.dtos.response.RoleResponse;
import com.grupo2.gestionpedidos.entities.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleResponse roleToRoleResponse(Role role);
    List<RoleResponse> rolesToRoleResponses(List<Role> roles);
}
