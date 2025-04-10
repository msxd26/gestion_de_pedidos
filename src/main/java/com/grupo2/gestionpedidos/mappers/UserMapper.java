package com.grupo2.gestionpedidos.mappers;

import com.grupo2.gestionpedidos.dtos.request.UserRequest;
import com.grupo2.gestionpedidos.dtos.response.RoleResponse;
import com.grupo2.gestionpedidos.dtos.response.UserResponse;
import com.grupo2.gestionpedidos.entities.Role;
import com.grupo2.gestionpedidos.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roles", ignore = true)
    User userRequestToUser(UserRequest request);

    @Mapping(source = "roles", target = "roles")
    UserResponse userToUserResponse(User user);

    List<UserResponse> usersToUserResponses(List<User> users);

    RoleResponse roleToRoleResponse(Role role);

    List<RoleResponse> rolesToRoleResponses(List<Role> roles);
}
